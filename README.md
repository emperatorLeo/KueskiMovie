# KueskiMovie

Este proyecto es una prueba tecnica para la empresa Kueski

Al correr la app, buscara la lista de las peliculas mas populares, posee en la parte de arriba para que filtres por nombre la peli que buscas entre la lista que trajo
si clickeas en un item te llevara al detalle

Está hecha con tecnologias como kotlin, Dagger hilt (Injección de dependencias), Corrutinas, Retrofit (Api calls) , jetPack compose, Mockk(Pruebas Unitarias)

Justificación de tecnologias usadas:

Kotlin como lenguaje de programación, Es un lenguaje que ofrece muchas bondades como manejo de la nullabilidad, usando este lenguaje tenemos tanto la programacion orientada a objetos como la programación funcional, además que se necesita mucho menos codigo para hacer todo lo que podemos hacer con java

Dagger Hilt: es un framework que nos ayuda con la injección de dependencias uno de sus beneficios es que crea el grafo de dependencias en tiempo de compilación por lo que no debemos esperar a que la aplicación corra para saber si hay alguna dependencia que tenemos mal.

Corrutinas: Emplea un codigo muy intuitivo para la ejecución de codigo en segundo plano.

Retrofit: Es casi un estandar en cuanto a las llamas a las APIs, es muy facil de utilizar y tiene excelente compatibilidad con las corrutinas (Flow)

JetPack Compose: Es un nuevo framework para crear la parte visual de las aplicaciones, es muy flexible y lo mejor de todo utiliza la recomposicion para cambiar la vista de acuerdo a los estados que esté escuchando.

Mockk: Es muy facil de usar para hacer testeo del codigo, especificamente codigo de Kotlin, posee una ventaja en comparacion con otros frameworks como es el uso de su anotacion @RelaxedMockk que permite mockear un objeto sin tener que crear todas sus dependencias.
