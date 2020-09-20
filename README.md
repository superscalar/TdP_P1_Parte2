# Proyecto 1 - Tecnologia de Programación
## Parte 2: Java Loggers

Este repositorio contiene una implementacion de un grafo dirigido no pesado con las operaciones:
* addNode(int node) : void
* addEdge(int node1, int node2) : void
* removeNode(int node) : void
* removeEdge(int node1, int node2) : void

Se implementan tres niveles de logging: INFO, FINE y WARNING.
El nivel INFO se utiliza cuando la instanciación de un grafo se hace exitosamente
El nivel FINE se utiliza cuando un grafo recibe un mensaje y lleva a cabo satisfactoriamente el metodo correspondiente.
El nivel WARNING se utiliza cuando algun metodo cuando un metodo no puede llevarse a cabo (por ejemplo, si se intenta agregar un nodo que ya existe, o eliminar un arco que no existe)
