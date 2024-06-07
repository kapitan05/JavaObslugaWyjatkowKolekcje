package mini.promy;

public abstract class Rakieta implements PojazdKosmiczny{

    //gotowe
    private int iloscTlenu;
    protected int iloscZalogi;
    protected String miejscePrzylotu;
    protected int dniPozaZiemia;

    public Rakieta(int iloscTlenu, int iloscZalogi, String miejscePrzylotu) throws WyjatekTransportu {
        if (iloscZalogi < 5)
            throw new WyjatekTransportu("Wczoraj kapitan miał urodziny, nie polecimy");
        if (iloscTlenu < 500)
            throw new WyjatekBrakTlenu("Mamy wyciek tlenu, polecimy, gdy tylko znajdzie się taśma klejąca");

        this.iloscTlenu = iloscTlenu;
        this.iloscZalogi = iloscZalogi;
        this.miejscePrzylotu = miejscePrzylotu;
        this.dniPozaZiemia = 0;
    }

    public void setIloscTlenu(int iloscTlenu) {
        this.iloscTlenu = iloscTlenu;
    }

    @Override
    public int getIloscTlenu() throws WyjatekBrakTlenu {
        if (iloscTlenu <= 100)
            throw new WyjatekBrakTlenu("Rakieta rozpoczęła przyspieszony powrót na Ziemię");
        return iloscTlenu;
    }

    @Override
    public void zuzycieTlenu(int utrataTlenu) {
        this.iloscTlenu -= utrataTlenu;
    }

    //gotowe
    @Override
    public String toString() {
        return "Lecimy na " + miejscePrzylotu + " już " + dniPozaZiemia +
                " dzień. Pozostało " + iloscTlenu + " jednostek tlenu na " +
                iloscZalogi + " czlonków załogi.";
    }

    //gotowe
    public void kolejnyDzien(){
        dniPozaZiemia++;
    }
}



