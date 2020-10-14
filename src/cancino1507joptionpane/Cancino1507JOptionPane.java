package cancino1507joptionpane;

import javax.swing.JOptionPane;

public class Cancino1507JOptionPane {
    
    public static void main(String[] args) {
         

        JOptionPane.showMessageDialog(null, "                                                        ¡Bienvenido/a/e!"
                                        + "\nA continuación deberá ingresar los datos de su vehículo"
                                        + " para dar de alta su seguro", "Sistema de Tramites de Seguro Automotriz", JOptionPane.INFORMATION_MESSAGE);
        //pedir año
        int anio;
        do{          
            anio= Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el año de fabricación de su vehículo (XXXX): ", 
                        "Año", JOptionPane.QUESTION_MESSAGE));
            if(anio<1950 || anio >2020){
                JOptionPane.showMessageDialog(null, "Ingrese un año válido", null, JOptionPane.WARNING_MESSAGE);
            }
        } while(anio<1950 || anio >2020);     
        //pedir marca
        int opcionMarca = JOptionPane.showOptionDialog(null, "Seleccione el tipo de marca de su vehículo",
                            "Marca", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, 
                            new Object[]{"Gama Media o Baja","Gama Alta"},"Gama Media o Baja");
        
        
        
        cuotaMensual(anio, opcionMarca);
    
    }//fin main class
    
    public static void cuotaMensual (int anioVehiculo, int opcionMarca){
       
        int cuotaPorAnio = 0;
        int cuotaPorMarca;
        int cuotaFinal;
        String marca="";
        
        //marcas Alta Gama
        if(opcionMarca == 1){
            Object marcasAltaGama[]= {"Alfa Romeo", "Aston Martin","Audi","Bentley","BMW",
                                    "Bugatti","Ferrari","Jaguar", "Koenigsegg","Lamborghini",
                                    "Lexus","Maserati","Porsche","Rolls-Royce","Volvo"};
            //indicar marca
            
            Object altaGama = JOptionPane.showInputDialog(null, "Indique la marca de su vehículo: "
                                + "\n(presione CANCELAR si no la encuentra)", "Marcas alta gama", JOptionPane.QUESTION_MESSAGE, 
                                null, marcasAltaGama, marcasAltaGama[0]);
            //si no se encuentra la marca
            if(altaGama == null){
                do{
                    marca = JOptionPane.showInputDialog(null, "Indique su marca:", "Marcas alta gama", 
                                                JOptionPane.QUESTION_MESSAGE);
                
                }while(marca== null);
            } else{
                marca = (String) altaGama; 
            }
            //advertencia por recargo
            JOptionPane.showMessageDialog(null, "Los vehículos de alta gama tienen un agregado de $820", 
                                            null, JOptionPane.WARNING_MESSAGE);
            
            //asignacion de valores
            cuotaPorMarca = 1200;
            
        } else{
            //marcas gama media o baja
            Object marcasGamaMediaBaja[]= {"Citröen","Chevrolet","Fiat","Ford","Honda",
                                    "Hyundai","Kia","Mazda","Mitsubishi","Nissan",
                                    "Peugeot","Renault","Suzuki","Toyota","Volkswagen"};
            //indicar marca
            Object gamaMediaBaja = JOptionPane.showInputDialog(null, "Indique la marca de su vehículo: "
                                    +"\n(presione CANCELAR si no la encuentra)","Marcas gama media/baja", JOptionPane.YES_NO_CANCEL_OPTION, null, 
                                     marcasGamaMediaBaja, marcasGamaMediaBaja[0]);
            
            // si no encuentra la marca
            if(gamaMediaBaja == null){
                do{
                    marca = JOptionPane.showInputDialog(null, "Indique su marca:", "Marcas gama media/baja", 
                                                JOptionPane.QUESTION_MESSAGE);
                }while(marca== null);
                
            } else{
                marca = (String) gamaMediaBaja; 
            }
            
            //asignacion de valores
            cuotaPorMarca = 980;
            
        }
        
        //cuota por año
        if (anioVehiculo<1990){
            cuotaPorAnio = 350;
        }
        if (anioVehiculo>=1990 && anioVehiculo<=1999){
            cuotaPorAnio = 480;
        }
        if (anioVehiculo>=2000 && anioVehiculo<=2010){
            cuotaPorAnio = 780;
        }
        if (anioVehiculo>=2011 && anioVehiculo<=2016){
            cuotaPorAnio = 950;
        }
        if (anioVehiculo>=2017 && anioVehiculo<=2020){
            cuotaPorAnio = 1200;
        }
        
        cuotaFinal = cuotaPorMarca + cuotaPorAnio;
        
        JOptionPane.showMessageDialog(null, 
                "Marca:  "+marca+
                "\nAño:  "+anioVehiculo+
                "\nCuota final por mes:  $"+cuotaFinal, "Cuota mensual de Seguro", JOptionPane.INFORMATION_MESSAGE);
        
    }//fin funcion cuota mensual
   
    
}//fin class
