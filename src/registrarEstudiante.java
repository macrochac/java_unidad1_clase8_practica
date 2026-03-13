import java.util.Scanner;

public class registrarEstudiante {
    static Scanner sc = new Scanner(System.in);
    static String nombreEstudiante = "";
    static double nota1 = 0;
    static double nota2 = 0;
    static double nota3 = 0;

    public static void main(String[] args) throws Exception {
        int opcion;
        do{
            opcion = menu(sc);
            if(opcion==1){
                registarEstudiante(sc);
            }else if(opcion==2){
                mostrarEstudiante();
            }else if(opcion==3){
                if(nota1==0){
                    System.out.println("\nNo tiene notas registradas");    
                }else{
                    System.out.printf("\nEl promedio del estudiante es: %.2f%n",calcularPromedio());    
                }
            }else if(opcion==0){
                sc.close();
                break;
            }else{
                System.out.println("Opcion invalida");
            }
        }while(opcion!=0);              

    }

    public static int menu(Scanner sc) {
        System.out.println("\n--- Sistema de Registro de Estudiantes ---");
        System.out.println("1. Registrar datos de un estudiante");
        System.out.println("2. Mostrar datos del estudiante actual");
        System.out.println("3. Calcular promedio de notas del estudiante actual");
        System.out.println("0. Salir");
        System.out.print("\nIngrese su opcion: ");
        int opcion=sc.nextInt();
        return opcion;
    }
    
    public static void registarEstudiante(Scanner sc) {
        do{
            System.out.print("\nIngrese nombre del estudiante: ");
            sc.nextLine();
            nombreEstudiante = sc.nextLine();
        
        }while(!validadNombre(nombreEstudiante));
        
        do{
            System.out.print("Ingrese Nota 1: ");
            nota1 = sc.nextDouble();
        }while(!validadNota(nota1));

        do{
            System.out.print("Ingrese Nota 2: ");
            nota2 = sc.nextDouble();
        }while(!validadNota(nota2));    

        do{
            System.out.print("Ingrese Nota 3: ");
            nota3 = sc.nextDouble();
        }while(!validadNota(nota3));
    }

    public static void mostrarEstudiante() {
        if(nombreEstudiante==""){
            System.out.println("\nActualmente no hay un registro de estudiante");
        }
        else{
            System.out.println("Nombre del Estudiante: " + nombreEstudiante);
            System.out.println("Nota 1: " + nota1);
            System.out.println("Nota 2: " + nota2);
            System.out.println("Nota 3: " + nota3);
        }
    }

    public static double calcularPromedio() {
        return (nota1+nota2+nota3)/3;
    }

    public static boolean validadNota(double nota) {
        if(nota>0 && nota<=5){
            return true;
        }
        else{
            System.out.println("\nNota Invalida intente de nuevo");
            return false;
        }
    }

    public static boolean validadNombre(String nombre) {
        if(nombre.isEmpty()){
            System.out.println("\nNombre Incorrecto");
            return false;
        }
        else{
            return true;
        }
    }

    public static void limpiarEstudiante() {
        nombreEstudiante = "";
        nota1 = 0;
        nota2 = 0;
        nota3 = 0;
    }

    public static void validarDatos() {
        
    }

    public static boolean siAprobo(double promedio) {
        if(promedio>3){
            return true;
        }else{
            return false;
        }
    }
}
