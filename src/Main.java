import ConversionResponse.ConversionResponse;
import com.google.gson.Gson;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner opcion = new Scanner(System.in);
        Conexion consulta = new Conexion();
        boolean continuar = true;
        String menu = """
                \n***************************************************
                *** Sea bienvenido al Conversor de Monedas ***
                
                1) Dolar ==>> Peso Argentino
                2) Peso argentino ==>> Dolar
                3) Dolar ==>> Real Brazileño
                4) Real Brazileño ==>> Dolar
                5) Dolar ==>> Peso Colombiano
                6) Peso Colombiano ==>> Dolar
                
                7) Salir

                ***************************************************
                """;
        do{
            try{
                Double monto = 0.0;
                String res = "";
                ConversionResponse conversion = null;
                System.out.println(menu);
                Gson gson = new Gson();
                System.out.println("Ingrese una opcion");
                var eleccion = Integer.parseInt(opcion.nextLine());
                switch (eleccion) {
                    case 1:
                        System.out.println("Ingrese monto");
                        monto = Double.parseDouble(opcion.nextLine());
                        res = consulta.consulta("USD","ARG",monto);
                        conversion = gson.fromJson(res, ConversionResponse.class);
                        System.out.println("El valor"+monto+"[USD] corresponde al valor final de =>>>" + conversion.getConversion_result()+"[ARG]");
                        break;
                    case 2:
                        System.out.println("Ingrese monto");
                        monto = Double.parseDouble(opcion.nextLine());
                        res = consulta.consulta("ARS","USD",monto);
                        conversion = gson.fromJson(res, ConversionResponse.class);
                        System.out.println("El valor"+monto+"[ARS] corresponde al valor final de =>>>" + conversion.getConversion_result()+"[USD]");
                        break;
                    case 3:
                        System.out.println("Ingrese monto");
                        monto = Double.parseDouble(opcion.nextLine());
                        res = consulta.consulta("USD","BRL",monto);
                        conversion = gson.fromJson(res, ConversionResponse.class);
                        System.out.println("El valor"+monto+"[USD] corresponde al valor final de =>>>" + conversion.getConversion_result()+"[BRL]");
                        break;
                    case 4:
                        System.out.println("Ingrese monto");
                        monto = Double.parseDouble(opcion.nextLine());
                        res = consulta.consulta("BRL","USD",monto);
                        conversion = gson.fromJson(res, ConversionResponse.class);
                        System.out.println("El valor"+monto+"[BRL] corresponde al valor final de =>>>" + conversion.getConversion_result()+"[USD]");
                        break;
                    case 5:
                        System.out.println("Ingrese monto");
                        monto = Double.parseDouble(opcion.nextLine());
                        res = consulta.consulta("USD","COP",monto);
                        conversion = gson.fromJson(res, ConversionResponse.class);
                        System.out.println("El valor"+monto+"[USD] corresponde al valor final de =>>>" + conversion.getConversion_result()+"[COP]");
                        break;
                    case 6:
                        System.out.println("Ingrese monto");
                        monto = Double.parseDouble(opcion.nextLine());
                        res = consulta.consulta("COP","USD",monto);
                        conversion = gson.fromJson(res, ConversionResponse.class);
                        System.out.println("El valor"+monto+"[COP] corresponde al valor final de =>>>" + conversion.getConversion_result()+"[USD]");
                        break;
                    case 7:
                        System.out.println("Saliendo del programa...");
                        continuar = false;
                        break;

                }



            }catch (RuntimeException e){

            }
        }while (continuar ==true);
        System.out.println("Gracias por usar el conversor de alura");


    }
}