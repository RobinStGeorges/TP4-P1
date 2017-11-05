
import java.util.Scanner;


public class Average {

    //METHODE fromStringArray(String[] args)

    public static int fromStringArray(String[] args){
        int accSomme=0;
        int accQt=0;
        int moy=0;
        int number=0;
        int erreur=0;

        for (int i=0;i<args.length;i++){

            //Cast du string en INT
            try {
                number=Integer.parseInt(args[i]);
            } catch (NumberFormatException e) {
                System.out.println("erreur la note NOTE n'est pas entière");
                erreur=1;
            }
            if (erreur !=1){
                try {
                    controle(number);
                } catch (NoteNonConformeException e) {
                    System.out.println("NoteNonConformeException: La note NOTE est non conforme (une note entre 0 et 20 est attendue)");
                    erreur=1;
                }

                //Ajout de la valeur au total

                //test si il y a eu une erreur
                if (erreur !=1){


                    //Ajout de la valeur au total
                    accSomme=accSomme+number;
                    //test
                    //System.out.println("accSomme "+i+" : "+accSomme);

                    //Incrémentation du suivi quantitatif
                    accQt=accQt+1;
                    //test
                    //System.out.println("accQt "+i+" : "+accQt);


                }
            }
            //Remise a zero du test d'erreur
            erreur=0;
        }

        //Calcule de la moyenne
        if(accQt!=0){
            moy=accSomme/accQt;
            return moy;
        }
        else{
            System.out.println("Il faut au moins une note");
            return 0;
        }

    }


    //NoteNonConformeException
    public static void controle(int num) throws NoteNonConformeException {

        if (num<0 || num>20)

            throw new NoteNonConformeException("Saisie erroné");
    }
    //MAIN
    public static void main(String[] args) {
        System.err.println(fromStringArray(args));
    }
}
