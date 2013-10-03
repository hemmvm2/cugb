(ns schema
  "Schema declaration and database initialization (drop + create)."
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.java.jdbc.ddl :as ddl]))


(defn id-column
  []
  [:id "integer generated by default as identity primary key"])

(defn fk-column
  ([table owned?]
     (fk-column table (keyword (str (name table) "_id")) owned?))
  ([table column owned?]
     [column (str "integer"
                  (if owned? " not null")
                  " references " (name table) " (id)"
                  (if owned? " on delete cascade on update cascade"))]))

(def schema {:project     [(id-column)
                           [:name "varchar(30)"]]
             :release     [(id-column)
                           (fk-column :project true)
                           [:name "varchar(30)"]]
             :member      [(id-column)
                           [:name "varchar(30)"]
                           (fk-column :project true)]
             :task        [(id-column)
                           [:summary "varchar(100)"]
                           (fk-column :release true)
                           (fk-column :member :owner_id false)]
             :watchers    [(fk-column :member :member_id true)
                           (fk-column :task :task_id true)]})


(defn- missing?
  [table column name]
  (empty? (jdbc/query db-spec (sql/select * table (sql/where {column name})))))


(defn create!
  [db-spec]
  (doseq [t (map (fn [[k v]] (cons k v)) schema)]
    (jdbc/execute! db-spec [(apply ddl/create-table t)]))
  (jdbc/execute! db-spec ["create sequence pkseq"]))


(defn drop!
  [db-spec]
  (doseq [t (keys schema)]
    (jdbc/execute! db-spec [(ddl/drop-table t)]))
  (jdbc/execute! db-spec ["drop sequence pkseq"]))
