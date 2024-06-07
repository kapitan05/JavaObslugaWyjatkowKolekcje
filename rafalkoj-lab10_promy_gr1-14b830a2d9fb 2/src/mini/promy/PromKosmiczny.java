package mini.promy;

public final class PromKosmiczny extends Rakieta{

    private int maxLadownosc;
    private int zaladowanie;

    public PromKosmiczny(int iloscTlenu, int iloscZalogi, String miejscePrzylotu, int maxLadownosc, int zaladowanie) throws WyjatekTransportu {
        super(iloscTlenu, iloscZalogi, miejscePrzylotu);
        if (zaladowanie < maxLadownosc / 2)
            throw new WyjatekBiznesowy("Dorzućcie jeszcze towaru");
        this.maxLadownosc = maxLadownosc;
        this.zaladowanie = zaladowanie;
    }

    public int getMaxLadownosc() {
        return maxLadownosc;
    }

    public int getZaladowanie() {
        return zaladowanie;
    }

    public void setMaxLadownosc(int maxLadownosc) {
        this.maxLadownosc = maxLadownosc;
    }

    public void setZaladowanie(int zaladowanie) {
        this.zaladowanie = zaladowanie;
    }


    @Override
    public int getIloscTlenu() throws WyjatekBrakTlenu {
        return super.getIloscTlenu();
    }

    @Override
    public void zuzycieTlenu(int ilosctTlenu) {
        super.zuzycieTlenu(ilosctTlenu);
    }

    //gotowe
    @Override
    public String toString() {
        return super.toString() +
                " Na pokładzie promu mamy " + zaladowanie +
                " ton ładunku.";
    }
}
