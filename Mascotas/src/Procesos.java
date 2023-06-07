
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Procesos {
	HashMap<Integer, Mascota> datos = new HashMap<Integer, Mascota>();
	Mascota miMascota = null;
    
	public void inicio(Procesos Procesos) {
		String menu = "Ingrese opción correcta\n";
		menu += "1. Ingresar mascotas\n";
		menu += "2. Imprimir datos\n";
		menu += "3. Consultar mascota\n";
		menu += "4. Sacar una mascota\n";
		menu += "5. SALIR";
		System.out.println(datos.size());
		int opcion = 0;
		do {
			opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
			opcion(opcion, Procesos);
		}while(opcion != 5);
	}
	
    public void opcion(int opcion, Procesos Procesos) {
    	switch (opcion) {
		case 1:
			guardarDatos();
			break;
		case 2:
			if(datos.size() != 0) {
				miMascota.imprimirD(Procesos);
			}else System.out.println("Llene los datos");
			break;
		case 3: 
			if(datos.size() != 0) {
				consultarMascotas();
			}else System.out.println("Llene los datos");
			break;
		case 4:
			if(datos.size() != 0) {
				miMascota.caminar(Procesos);
			}else System.out.println("Llene los datos");
			System.out.println("-----");
			break;
		case 5: 
			System.out.println("ADIOS");
			break;
		default:
			JOptionPane.showMessageDialog(null, "¡INGRESE OPCÍON VALIDA!", "ERROR", JOptionPane.ERROR_MESSAGE);
			break;
		}
    }
    
    public void guardarDatos() {
        int cantidad = 0;
        do {
        	miMascota = new Mascota();
            miMascota.ingresarDatos(datos.size()+ 1);
            miMascota.hacerSonido();
            datos.put(miMascota.getCodigo(), miMascota);
            miMascota.mostrarInformacion();
            cantidad = valido("Ingrese: \n1. Continuar con otra mascota\n2. SALIR");
        }while(cantidad == 1);	
    }
    
    public int valido(String msj) {
    	int x = 0;
    	do {
    		x = Integer.parseInt(JOptionPane.showInputDialog(msj));
    		if(x < 1 || x > 2) {
    			JOptionPane.showMessageDialog(null, "¡INGRESE OPCÍON VALIDA!", "ERROR", JOptionPane.ERROR_MESSAGE);
    		}
    	}while(x < 1 || x > 2);
    	return x;
    }
    
    public void consultarMascotas() {
    	int cantidad = 0;
        do {
        	int llave = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el ID de la mascota a consultar:"));
            Mascota mascota = datos.get(llave);
            if (mascota != null) {
                System.out.println("ID: " + llave);
                System.out.println("Nombre: " + mascota.getNombre());
                System.out.println("Especie: " + mascota.getEspecie());
                System.out.println("Edad: " + mascota.getEdad());
                System.out.println("-----");
            } else {
                System.out.println("No se encontró una mascota con el ID especificado.");
                System.out.println("-----");
            }
            cantidad = valido("Ingrese: \n1. Consultar otra mascota\n2. SALIR");
        }while(cantidad == 1);	
    }

    public HashMap<Integer, Mascota> getDatos() {
        return datos;
    }

}