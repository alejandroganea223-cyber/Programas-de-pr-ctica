import threading
import random
import time
import sys
x_1 = None
x_2 = None
Palabras_necesarias = ["cara", "cruz"]
system_statement = {"activo": True}
def safe_print(texto, fila=1):
    sys.stdout.write(f"\033[s")
    sys.stdout.write(f"\033[{fila};1H")
    sys.stdout.write(f"\033[K") 
    sys.stdout.write(texto)
    sys.stdout.write("\033[u")
    sys.stdout.flush()
def bash_comand():
    global system_statement
    while system_statement["activo"]:
        sys.stdout.write("\033[22;1H\033[K>> ")
        sys.stdout.flush()
        comand = input()
        sys.stdout.write("\033[22;1H\033[K")
        sys.stdout.flush()
        if comand.lower() == "the end":
            sys.stdout.write("\033[23;1HGracias por su tiempo\n")
            system_statement["activo"] = False
            break
sys.stdout.write("\033[2J")
sys.stdout.write("\033[21;1H" + "=" * 50)
sys.stdout.flush()
hilo = threading.Thread(target=bash_comand, daemon=True)
hilo.start()
while True:
    if not system_statement["activo"]:
        break
    count_rep = 0
    limit_rep = 100
    file_log = 1
    while count_rep < limit_rep:
        count_rep += 1
        try:
            x_1 = random.choice(Palabras_necesarias)
            x_2 = random.choice(Palabras_necesarias)
            for _ in range(20):
                if not system_statement["activo"]:
                    break
                time.sleep(0.1)
            z_1 = ""
            z_2 = ""
            if x_1 not in Palabras_necesarias or x_2 not in Palabras_necesarias:
                raise ValueError("Palabra incorrecta")
            else:
                match x_1:
                    case "cara":
                        z_1 = True
                    case "cruz":
                        z_1 = False
                match x_2:
                    case "cara":
                        z_2 = True
                    case "cruz":
                        z_2 = False
                if x_1 == x_2:
                    if z_1 == z_2:
                        safe_print("Misma cara de la moneda", fila=1)
                        safe_print(f"{z_1} -|- {z_2}            ", fila=2)
                    else:
                        safe_print("Misma cruz de la moneda", fila=1)
                        safe_print(f"{z_1} -|- {z_2}            ", fila=2)
                elif x_1 != x_2:
                    if z_1 == True and z_2 == False:
                        safe_print("La cara por la segunda de la cruz", fila=1)
                        safe_print(f"{z_1} -|- {z_2}            ", fila=2)
                    else:
                        safe_print("La cruz clavada por la segunda de la cara", fila=1)
                        safe_print(f"{z_1} -|- {z_2}            ", fila=2)
        except ValueError:
            safe_print("Error, por causas inesperadas, por favor intentelo más tarde", fila=1)
            break