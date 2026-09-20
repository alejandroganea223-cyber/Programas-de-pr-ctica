import time
x = 5
desplazamiento = 0
direccion = 1
limite_max = 20
# Piramide pero con desplazamiento
while True:
    for i in range(1, x + 1):
        f = " " * (x - i + desplazamiento)
        z = "*" * (2 * i - 1)
        print(f + z)
    time.sleep(0.1)
    #Controlador de animación
    desplazamiento += direccion
    if desplazamiento >= limite_max:
        direccion = -1
    elif desplazamiento <= 0:
        direccion = 1
