package br.com.sixtechsolutions;

import br.com.sixtechsolutions.ControladorDeCenas;

public interface CenaControlada {
    
    //This method will allow the injection of the Parent ScreenPane
    public void defineCenaPai(ControladorDeCenas screenPage);
}