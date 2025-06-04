#🐾 Juego Adivinanza
Trabajo integrador (parcial) donde se repasan conceptos de grafos, árboles, estructuras de datos y lógica utilizando el lenguaje Java.

🧠 Descripción del Proyecto
Este proyecto consiste en un juego de adivinanza en el que el programa intenta adivinar el animal en el que está pensando el usuario, a partir de preguntas de sí / no.
Para lograrlo, se utiliza un árbol binario de decisiones, donde:

  Cada nodo intermedio representa una pregunta.

  Cada hoja representa un animal (una posible respuesta final).

  A medida que el usuario responde, el programa avanza por el árbol hasta llegar a una conclusión.

  Si el sistema falla al adivinar, el usuario tiene la opción de enseñarle un nuevo animal y una pregunta para diferenciarlo, permitiendo que el árbol crezca y mejore con el tiempo.

#🎯 Objetivos

Crear un sistema que adivine animales a partir de preguntas simples (sí / no).

Permitir que el árbol crezca con nuevos animales y preguntas (retroalimentación).

Hacer que el usuario pueda jugar todas las veces que desee.

Incluir una opción para que el usuario pueda rendirse y finalizar el juego.

⚙️ Funcionalidades Principales
  🌱 Construcción del Árbol Inicial
  El árbol parte de una estructura mínima con algunas preguntas y animales predefinidos.
  Puede expandirse a medida que el sistema aprende.
  
  🎮 Jugar una Partida
  El usuario piensa en un animal y responde preguntas. El sistema intentará adivinar correctamente.
  
  📚 Aprendizaje del Sistema
  Si el sistema no adivina correctamente, se inicia un proceso de aprendizaje:
  
  El usuario ingresa el animal correcto.
  
  Proporciona una pregunta que lo diferencie del animal anterior.
  
  Indica si la respuesta a esa pregunta para el nuevo animal es "sí" o "no".
  
  El árbol se actualiza en memoria.
  
  🏳️ Rendirse
  El usuario puede abandonar la partida escribiendo "rendirse".

🌳 Estructura del Árbol
  Tipos de Nodos
  Nodo de pregunta: contiene una pregunta (ej. ¿Vuela? ¿Es mamífero?).
  
  Nodo de respuesta: contiene un animal (ej. ¿Es un perro?).
  
  Direcciones del Árbol
  Respuesta "Sí" → rama izquierda.
  
  Respuesta "No" → rama derecha.

🔄 Flujo Básico del Juego
  El sistema inicia desde la raíz del árbol.
  
  Formula preguntas según los nodos intermedios.
  
  Al llegar a una hoja, realiza una suposición.
  
  Si adivina correctamente, muestra un mensaje de éxito.
  
  Si falla, solicita al usuario que le enseñe:
  
  Qué animal era.
  
  Qué pregunta lo distingue.
  
  Cuál es la respuesta correcta a esa pregunta.
  
  Se actualiza el árbol con esta nueva información.

🧩 Función: construirArbolDesdeCero()

📌 Propósito

Permite construir manualmente el árbol de decisiones desde cero, solicitando al usuario preguntas y animales, y generando los nodos de forma recursiva.
Cumple con el requisito de la consigna: "construir el árbol mediante inserciones".

🏗️ Lógica de Funcionamiento
Se solicita una pregunta raíz, que será el nodo principal del árbol.

Para cada rama ("Sí" / "No"):

Se pregunta si el siguiente nodo será otra pregunta o un animal.

Si es una pregunta → se crea un nuevo nodo y se repite el proceso.

Si es un animal → se crea un nodo hoja.

El proceso continúa hasta que el árbol esté completamente definido.

🧪 Entradas
Un objeto Scanner para leer desde la consola.

Las respuestas del usuario sobre:

El texto de la pregunta o animal.

Si lo que se desea insertar es una pregunta o un animal.

📤 Salidas
Se genera y asigna la raíz del árbol con su estructura completa.

No devuelve valores explícitos: modifica el árbol en memoria.

🛠️ Mejoras Pendientes
Implementar la función para iniciar el juego con un árbol predefinido cuando el usuario haga clic en "Jugar adivina el animal".

Mejorar y enriquecer el output del sistema (mensajes, interacción con el usuario).

Agregar un gráfico del árbol para facilitar la explicación de su funcionamiento.

📌 Consigna Original
Introducción:
Crea un programa que adivine un animal a partir de preguntas de sí/no. Utiliza un árbol binario de decisiones donde cada nodo representa una pregunta, y las hojas representan los animales. El programa debe ir haciendo preguntas hasta llegar a la hoja correcta.

Proceso:

Grafique algunos ejemplos y analice lo que se describe.

Determine las preguntas de su juego (por ejemplo: ¿es mamífero?).

Seleccione el tipo de árbol adecuado.

Defina la implementación y clases necesarias.

Implemente la clase Árbol, su constructor, y si es necesario, la clase Nodo.

El programa debe tener un menú que permita:

Construir el árbol mediante inserciones.

Jugar todas las veces que el usuario desee.

Establecer una opción para rendirse.

