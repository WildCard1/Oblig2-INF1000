
//	Dette programmet er obligatorisk oppgave nr 2 i INF1000 Hoest 2012
//	Oppgaven er skrevet av Henrik Hansen for Gruppe 16.
//	Funksjonen til dette programmet er aa holde styr paa fiktive oljefelt
//	i det fiktive landet Ruritania. Brukeren er hovedsaklig ment aa vaere
//	en funksjonaer, og dialogene/meldingene til brukeren er ment aa reflektere dette.
//	Korrekt kontaktadresse er henrik.hansen@student.jus.uio.no 
 
import java.util.*;

class Oblig2 {
	public static void main(String[]args){
		Beregninger olje = new Beregninger();
		olje.meny();
	}
}

class Beregninger {
	Scanner tast = new Scanner(System.in);	
	boolean felterLedige = false; 
	String operatorselskap[][] = new String[10][20];
	double oljeutvinning[][] = new double[10][20];

void meny() {
	System.out.println(""); //Litt pusterom er aldri feil!
	System.out.println("Velkommen til Ruritanias oljefeltoversikt. Du faar naa 6 valg: \n");
	System.out.println("1. Kjoep et felt");
	System.out.println("2. Annuler kjoep av et felt");
	System.out.println("3. Lag oversiktskart ");
	System.out.println("4. Oppdater oljeutvinning for ditt selskap");
	System.out.println("5. Vis ett oljeselskap");
	System.out.println("6. Avslutt");
	System.out.print("\nTast inn det respektive tall for hva du oensker aa gjoere(1 til 6): ");

	int menyvalg = tast.nextInt();
	
	while (menyvalg > 6 || menyvalg < 1) {
		System.out.print("Du maa velge et valg mellom 1 og 6: ");
		menyvalg = tast.nextInt();
	} // Slutt paa while.

	switch (menyvalg) {
		case 1:
			kjop1();
			break;
		case 2:
			annulering();
			break;
		case 3: 
			oversiktskart();
			break;
		case 4: 
			oljeutvinning();
			break;
		case 5:
			visSelskap();
			break;
		case 6:
			System.out.println("\nSystemet vil naa avslutte, paa anmodning fra brukeren. Ha en fin dag!\n");
			System.exit(0);
			break;	

	} // Slutt paa switch-setning.
} // Slutt paa metoden "meny"

void kjop1() {
	
    for (int i = 0; i < operatorselskap.length; i++) {
	for (int j = 0; j < operatorselskap[i].length; j++) {
	    if (operatorselskap[i][j] == null) {
		felterLedige = true;			
	    }// Slutt paa if
	
	} // Slutt paa andre for-loekke
    } // Slutt paa foerste for-loekke

	if (felterLedige == true) {
		kjop2();
	} else {
	    System.out.println("\nBeklager, det er ingen ledige felter igjen.");
	    meny();
	}
	
	felterLedige = false;
} // Slutt paa metoden "kjop1"

void kjop2(){

	System.out.println("\nVelg hvilket felt du vil kjoepe. Dette er i formatet 'x-y' der 'x' er rad og 'y' er kolonne. ");
	System.out.print("Velg rad, fra 0 til 9: ");
	int rad = tast.nextInt();

	while (rad > 9 || rad < 0) {
		System.out.print("Du maa velge et radnr mellom 0 og 9: ");
		rad = tast.nextInt();
	} // Slutt paa while-loekke

	System.out.print("Velg kolonnenr, fra 0 til 19: "); 
	int kolonne = tast.nextInt();

	while (kolonne > 19 || kolonne < 0) {
		System.out.print("Du maa velge et kolonnenr mellom 0 og 19: ");
		kolonne = tast.nextInt();
	} // Slutt paa while-loekke

	if (operatorselskap[rad][kolonne] == null) {
		System.out.print("Hvilket operatoerselskap representerer du?: "); 
		operatorselskap[rad][kolonne] = tast.next();
		System.out.println("\nFeltet " + rad + "-" + kolonne + " selges til " + operatorselskap[rad][kolonne]);
		}else	{
				System.out.println("Beklager, dette feltet er dessverre kjoept og eiges av " + operatorselskap[rad][kolonne]);
			} // Slutt paa else
      
	meny();


} // Slutt paa metoden "kjop2"

void annulering() {

	System.out.print("Hva er navnet paa oljeselskapet du oensker aa annulere et felt-kjoep for(husk 'case-sensitiv')?: ");
	String operatorselskap1 = tast.next();

	System.out.print("\nHvilket radnr er det paa feltet du oensker annulert?: ");
	int rad1 = tast.nextInt();

	while (rad1 > 9 || rad1 < 0) {
		System.out.print("Du maa velge et radnr mellom 0 og 9: ");
		rad1 = tast.nextInt();
	} // Slutt paa while-loekke.

	System.out.print("\nHvilket kolonnenr er det paa feltet du oensker annulert?: ");
	int kolonne1 = tast.nextInt();

	while (kolonne1 > 19 || kolonne1 < 0) {
		System.out.print("\nDu maa velge et kolonnenr mellom 0 og 19: ");
		kolonne1 = tast.nextInt();
	}

	String[][] operatorselskap2 = new String[10][20];
	operatorselskap2[rad1][kolonne1] = operatorselskap1;

	if (operatorselskap2[rad1][kolonne1].equals(operatorselskap[rad1][kolonne1])) {
		operatorselskap[rad1][kolonne1] = null;
		System.out.println("\nFelt " + rad1 + "-" + kolonne1 + " er naa ikke lenger eid av " + operatorselskap2[rad1][kolonne1] + " og er foelgelig ledig for salg");
		}else 	{
			System.out.println("\nFelt " + rad1 + "-" + kolonne1 + " er ikke eid av " + operatorselskap2[rad1][kolonne1] + " og kan dermed ikke frigjoeres");
		}
	
	meny();

} //Slutt paa metoden annulering

String[][] oversiktskart = new String[10][20];

void oversiktskart() {
	System.out.println("");
	System.out.println("");
	System.out.println("0| 1 |2 |3 |4 |5 |6 |7 |8 |9 |10|11|12|13|14|15|16|17|18|19");
	
	for (int i = 0; i < operatorselskap.length; i++) {
		for (int j = 0; j < operatorselskap[i].length; j++) {
			if (operatorselskap[i][j] == null) {
				System.out.print("." + "  ");
				} else	{
					System.out.print("x" + "  ");
				} // Slutt paa else

		} // Slutt paa andre for-loekke
System.out.println();
	} // Slutt paa foerste for-loekke

	meny();

} //Slutt paa metoden "oversiktskart"

int[][] fatfelt = new int[10][20];
int fat;
int rad2;
int kolonne2;

void oljeutvinning() {

	System.out.println("");
	System.out.print("Hvilken er rad er det paa feltet du oensker aa oppdatere oljeutvinningen paa?: ");
	rad2 = tast.nextInt();

	while(rad2 > 9 || rad2 < 0) {
		System.out.println("Du maa velge et radnr mellom 0 og 9: ");
		rad2 = tast.nextInt();
	} // Slutt paa while-loekke  

	System.out.print("Hvilket kolonnenr er det paa feltet du oenker aa oppdatere oljeutvinningen paa?: ");
	kolonne2 = tast.nextInt();

	while (kolonne2 > 19 || kolonne2 < 0) {
		System.out.print("Du maa velge et kolonnenr mellom 0 og 19: ");
		kolonne2 = tast.nextInt();
	} // Slutt paa while-loekke

	System.out.print("Hvor mange fat har det blitt utvinnet i den siste perioden?: ");
	fat = tast.nextInt();
	fatfelt[rad2][kolonne2]+= fat; 

	System.out.println("\n Totalt utvunnet paa felt " + rad2 + "-" + kolonne2 + " er " + fatfelt[rad2][kolonne2] + " fat\n");
	meny(); 

} // Slutt paa metoden "oljeutvinning"

String oljeselskap3;

void visSelskap() {

	System.out.print("Hva er navnet paa oljeselskapet du vil ha informasjon om?: ");
	oljeselskap3 = tast.next();
	boolean harFelt = false;
	
	for (int i = 0; i < operatorselskap.length; i++) {
		for (int j = 0; j < operatorselskap[i].length; j++) {
			if (operatorselskap[i][j] != null && oljeselskap3.equals(operatorselskap[i][j])) {
				System.out.println("");
				System.out.print(oljeselskap3 + " eier " + "felt " + i + "-" + j);
				System.out.println(" og her er det utvunnet totalt " + fatfelt[i][j] + " fat olje\n");
			} //Slutt paa if
			
	if (oljeselskap3.equals(operatorselskap[i][j])) 
		harFelt = true; 
	
		} // Slutt paa andre for-loekke.
	} // Slutt paa foerste for-loekke

	if (!harFelt)
		System.out.println("\nBeklager " + oljeselskap3 + " eier ingen felt her.");

	harFelt = false;

	meny();

} // Slutt paa metoden "visSelskap"

} //Slutt paa klassen "Beregninger"



	
