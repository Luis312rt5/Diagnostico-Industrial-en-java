Taller – Sistemas Expertos




Luisney Fernando Rojas Villalba
Jhon Esteban Pinto Rodríguez



Ingeniería de software, Fundación Escuela Tecnológica de Neiva


Sistemas Expertos



20 de Febrero de 2026
Neiva – Huila
TALLER – SISTEMAS EXPERTOS
PARTE 1 – Análisis
1.¿Cuál es el problema que resolverá el sistema experto?
	Respuesta: El problema principal es que en una planta industrial no siempre se puede depender de la presencia constante de un técnico especializado para supervisar el estado de las máquinas en todo momento. Muchas fallas comienzan con pequeñas señales como aumento de temperatura, vibraciones inusuales o ruidos anormales que pueden pasar desapercibidos. Lo que busca el sistema experto es analizar esas tres variables: temperatura, vibración y nivel de ruido, para detectar patrones que indiquen una posible falla. De esta manera, el sistema puede emitir un diagnóstico preliminar y generar una alerta antes de que el problema se convierta en una avería grave que detenga la producción.
2.¿Que conocimiento necesitaria el Sistema?
Respuesta: Para funcionar correctamente, el sistema necesitaría conocer cuáles son los rangos normales de operación de temperatura, vibración y ruido para cada tipo de máquina. Además, debe saber qué combinaciones específicas de esas variables representan una posible falla. Por ejemplo, si la vibración es alta y el ruido también aumenta, podría tratarse de desgaste en los rodamientos; si la temperatura sube demasiado junto con ruido elevado, podría indicar falta de lubricación. Este conocimiento no surge al azar, sino que proviene de manuales técnicos, registros históricos de fallas y, sobre todo, de la experiencia práctica de ingenieros y técnicos de mantenimiento que ya han enfrentado esos problemas en la realidad.
3.¿En que se diferencia este Sistema de un software tradicional?
Respuesta: Un software tradicional simplemente ejecuta instrucciones programadas de manera fija: si ocurre una condición específica, responde de una forma determinada. No interpreta ni razona más allá de lo que fue codificado paso a paso. En cambio, un sistema experto trabaja con una base de conocimiento y reglas que le permiten analizar varias condiciones al mismo tiempo y llegar a conclusiones similares a las de un especialista humano. Además, puede justificar su diagnóstico explicando qué reglas se activaron, y es más flexible, ya que para mejorarlo no es necesario reprogramar todo el sistema, sino simplemente agregar o modificar reglas dentro de su base de conocimiento.
PARTE 2 – Construccion de Reglas
1. Escriba almenos 5 reglas del tipo SI – ENTONCES.
-Regla 1:
SI la temperatura es alta Y la vibración es normal
ENTONCES existe posible sobrecalentamiento del motor.
-Regla 2:
SI la vibración es alta Y el ruido es alto
ENTONCES existe posible desgaste de rodamientos.
-Regla 3:
SI la vibración es alta Y la temperatura es moderada
ENTONCES existe posible desalineación del eje.
-Regla 4:
SI la temperatura es alta Y el ruido es alto
ENTONCES existe posible falta de lubricación.
-Regla 5:
SI la temperatura es muy alta Y la vibración es alta Y el ruido es alto
ENTONCES existe una posible falla crítica Y se recomienda detener la máquina inmediatamente.
2. Identifique que datos serian hechos.
Respuesta: Los hechos son los datos reales que el sistema recibe en un momento determinado. En este caso, serían los valores actuales de temperatura, vibración y nivel de ruido que provienen de sensores instalados en la maquinaria. Por ejemplo: temperatura = 95°C, vibración = alta, ruido = alto. Esos datos se almacenan temporalmente en la base de hechos y el sistema los utiliza para compararlos con las reglas disponibles. Cada vez que cambian los valores, cambian también los hechos, y el sistema vuelve a evaluar el diagnóstico.
3. Indique que componente ejecuta el razonamiento.
Respuesta: El componente encargado del razonamiento es el motor de inferencia. Este es el elemento central del sistema experto, porque es el que analiza los hechos y los compara con las reglas definidas en la base de conocimiento. Cuando encuentra que se cumplen las condiciones de una regla, genera automáticamente la conclusión correspondiente. En este caso, lo más adecuado sería utilizar encadenamiento hacia adelante, ya que el sistema parte de los datos que llegan desde los sensores y, a partir de ellos, deduce el diagnóstico. Sin el motor de inferencia, el sistema no podría razonar ni tomar decisiones, solo almacenaría información sin interpretarla.
