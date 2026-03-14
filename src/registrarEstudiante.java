import java.util.Scanner;

public class registrarEstudiante {
    static Scanner sc = new Scanner(System.in);
    static String nombreEstudiante = "";
    static double nota1 = 0;
    static double nota2 = 0;
    static double nota3 = 0;
    static String mensaje ="";

    public static void main(String[] args) throws Exception {
        int opcion;
        do{
            opcion = menu(sc);
            switch (opcion) {
                case 1:
                    System.out.println("\n-- Registrando Estudiante ---");
                    validarEstudiante(sc);
                    break;
                case 2:
                    mostrarEstudiante();
                    break;
                 case 3:
                    if(nota1==0){
                        System.out.println("\nNo tiene notas registradas");    
                    }else{
                        System.out.println("\n-- Calculando Promedio ---");
                        System.out.printf("\nEl promedio del estudiante es: %.2f%n",calcularPromedio());    
                        System.out.println("El estudiante "+mensaje);
                    }
                    break;
                case 4:
                    if(nombreEstudiante!=""){
                        System.out.println("\n-- Borrar datos de Estudiante --");    
                        borrarEstudiante();
                    }else{
                        System.out.println("\n-- No hay datos que borrar --");    
                    }
                    break;
                case 0:
                    sc.close();
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
         }while(opcion!=0);              

    }

    public static int menu(Scanner sc) {
        int opcion = 0;
        System.out.println("\n--- Sistema de Registro de Estudiantes ---\n");
        System.out.println("1. Registrar datos de un estudiante");
        System.out.println("2. Mostrar datos del estudiante actual");
        System.out.println("3. Calcular promedio de notas del estudiante actual");
        System.out.println("4. Borrar datos de Estudiante");
        System.out.println("0. Salir");
        System.out.print("\nIngrese su opcion: ");
        if(sc.hasNextInt()){
            opcion=sc.nextInt();
            sc.nextLine();
        }else{
            opcion=6;
            sc.nextLine();
        }
        return opcion;
    }
    
    public static void registarEstudiante(Scanner sc) {
        do{
            System.out.print("\nIngrese nombre del estudiante: ");
            nombreEstudiante = sc.nextLine();
        
        }while(!validarNombre(nombreEstudiante));
        
        nota1 = validarDouble(sc,1);
        nota2 = validarDouble(sc,2);
        nota3 = validarDouble(sc,3);

    }

    public static void mostrarEstudiante() {
        if(nombreEstudiante==""){
            System.out.println("\nActualmente no hay un registro de estudiante");
        }
        else{
            System.out.println("\n-- Imprimiendo Datos de Estudiante ---");
            System.out.println("\nNombre del Estudiante: " + nombreEstudiante);
            System.out.println("Nota 1: " + nota1);
            System.out.println("Nota 2: " + nota2);
            System.out.println("Nota 3: " + nota3);
        }
    }

    public static double calcularPromedio() {
        double promedio = (nota1+nota2+nota3)/3;
        if(siAprobo(promedio)){
            mensaje = "APROBO, felicitaciones";
        }
        else{
            mensaje = "REPROBO, debe volver a estudiar";
        }
        return promedio;
    }

    public static double validarDouble(Scanner sc, int num) {
        double nota = 0;
        boolean sw = false;
        while(sw==false){
            System.out.print("Ingrese Nota "+num+" : ");
            if(sc.hasNextDouble()){
                nota = sc.nextDouble();
                sc.nextLine();
                 if(nota>0 && nota<=5){
                    sw=true;
                 }else{
                    System.out.print("\nNota Invalida intente de nuevo");
                 }
            }
            else{
                System.out.print("\nNota Invalida intente de nuevo");
                sc.nextLine();
            }
         }
         return nota;     
    }

    public static boolean validarNombre(String nombre) {
        if(nombre.isEmpty()){
            System.out.println("\nNombre Incorrecto");
            return false;
        }
        else{
            return true;
        }
    }

    public static void borrarEstudiante() {
        nombreEstudiante = "";
        nota1 = 0;
        nota2 = 0;
        nota3 = 0;
    }

    public static void validarEstudiante(Scanner sc) {
        String validar ="";
        String valor = "";
        do{
            if(nombreEstudiante!=""){
                System.out.print("Hay un estudiante registrado, desea sobrescribir los datos (si o no): ");
                validar = sc.nextLine();
                switch (validar) {
                    case "si":
                        valor="si";
                        borrarEstudiante();
                        registarEstudiante(sc);
                        break;
                    case "no":
                        valor="no";
                        break;
                    default:
                        System.out.println("Escriba si o no, nada mas");
                        break;
                }        
            }
            else{
                registarEstudiante(sc);
                break;
            }
        }while(!validar.equalsIgnoreCase(valor));
    }

    public static boolean siAprobo(double promedio) {
        if(promedio>3){
            return true;
        }else{
            return false;
        }
    }
}
