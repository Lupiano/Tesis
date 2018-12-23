## ClusterApp.jar

Los resultados serán guardados en results.txt. En caso de errores, los logs se guardarán en error_logs.txt.

Archvios y carpetas necesarias para la ejecución de ClusterApp.jar:

### config

Carpeta que contiene las refactorizaciones manuales en formato JSON.

### config.json

Valores de configuración para ejecución de la técnica de clustering:
  - __manual_refactoring__: nombre del JSON de la refactorización manual a utilizar.
  - __clustering_strategy__: algoritmo a utilizar a nivel operación.
  - __cluster_count__: cantidad de clusters a generar a nivel operación (para algoritmos K-Means y EM).
  - __split_terms__: realizar spliteado de términos.
  - __do_filtering__: realizar filtrado de términos.
  - __filter_terms_size__: cantidad de caractéres mínima de los términos.
  - __blacklist__: lista de términos que deben filtrarse.
  - __do_wsdl_clustering__: realizar clustering a nivel WSDL.
  - __wsdl_clustering_strategy__: algoritmo a utilizar a nivel WSDL.
  - __wsdl_cluster_count__: cantidad de clusters a generar en agrupamiento a nivel WSDL (para algoritmos K-Means y EM).
  
### dataset

Carpeta que contiene el dataset de archivos WSDL original.

