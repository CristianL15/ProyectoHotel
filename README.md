# Proyecto Simulación de Hotel 
Backend - Taller pensando en objetos 

## Descripción
Bienvenido al repositorio del backend de la Simulación de un Hotel. Esta simulación se basa en decisiónes por parte del usuario. Puede actuar y realizar acciones dependiendo del rol que elija.

[!IMPORTANT]
## Desarrolladores:
- Cristian Lizarazo Camaño
- Nataly Lievano Arroyo

[!NOTE]
## Supuestos
- Al inicializar el programa por la opción 2 (Objetos ya creados e inicializados), se crean el hotel, las habitaciones, los empleados, y los menús. Los clientes (Guests) hay que ingresarlos durante la simulación.
- Los clientes solo pueden hacer una reservación de habitación por estadía. Si intenta hacer otra reservación con el mismo ID, el programa no lo permitirá. 
- Los clientes que vengan en grupo o familia, deben registrar primero al responsable o persona quien pagará la factura al final de la estadía del grupo
- En la simulación, el usuario solo puede elegir a los clientes que sean adultos
- A los menores de edad no se les registra su número de identificación ni su número de celular
- El hotel depende de los empleados --> No es un hotel autónomo en el que los propios clientes hacen su ingreso
- Las recepcionistas son quienes hacen el check-in de los usuarios --> Suponiendo el caso real en el que es la recepcionista quien ingresa a un usuario.
- Solo hay un menú con todos los items
- Todos los items están siempre disponibles
- Los platos son generales --> Los chefs no tienen un platillo con su sello o que solo ese chef prepare
- La orden de un servicio se añade a la factura después de ser realizadas por un empleado
- Los precios se manejan con el peso colombiano
- Todas las habitaciones están bien equipadas de inventario (toallas, sábanas, almohadas, papel higiénico, baño)
- Solo las mucamas se ocupan al realizar una tarea (limpiar habitación) por tiempo --> Hay que esperar 2 minutos para que se desocupen y volver a elegir a esa persona
- 