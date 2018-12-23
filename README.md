Archvios y carpetas necesarias para la ejecución de ClusterApp.jar:

Config: carpeta que contiene las refactorizaciones manuales en formato JSON.

config.json: configuraciones de la técnica de clustering y V-Measure:
  - manual_refactoring: nombre del JSON de la refactorización manual a utilizar.
  - clustering_strategy: algoritmo a utilizar a nivel operación.
  - cluster_count: cantidad de clusters a generar a nivel operación (para algoritmos K-Means y EM).
  - split_terms: realizar spliteado de términos.
  - do_filtering: realizar filtrado de términos.
  - filter_terms_size: cantidad de caractéres mínima de los términos.
  - blacklist: lista de términos que deben filtrarse.
  - do_wsdl_clustering: realizar clustering a nivel WSDL.
  - wsdl_clustering_strategy: algoritmo a utilizar a nivel WSDL.
  - wsdl_cluster_count: cantidad de clusters a generar en agrupamiento a nivel WSDL (para algoritmos K-Means y EM).
  
dataset: carpeta que contiene el dataset de archivos WSDL original.

