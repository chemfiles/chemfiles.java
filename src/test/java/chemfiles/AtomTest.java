import static org.junit.Assert.assertEquals;
import org.junit.Test;

import chemfiles.Atom;
import chemfiles.ChemfilesException;

public class AtomTest {
    @Test public void name() throws ChemfilesException {
        Atom atom = new Atom("He");
        assertEquals(atom.name(), "He");
        atom.set_name("Zn");
        assertEquals(atom.name(), "Zn");
    }

    @Test public void full_name() throws ChemfilesException{
        Atom atom = new Atom("He");
        assertEquals(atom.full_name(), "Helium");
        atom.set_name("Zn");
        assertEquals(atom.full_name(), "Zinc");
    }

    @Test public void mass() throws ChemfilesException {
        Atom atom = new Atom("He");
        assertEquals(atom.mass(), 4.002602100, 1e-9);
        atom.set_mass(22);
        assertEquals(atom.mass(), 22, 1e-6);
    }

    @Test public void charge() throws ChemfilesException {
        Atom atom = new Atom("He");
        assertEquals(atom.charge(), 0, 1e-9);
        atom.set_charge(-3.2f);
        assertEquals(atom.charge(), -3.2, 1e-6);
    }

    @Test public void type() throws ChemfilesException {
        Atom atom = new Atom("He");
        assertEquals(atom.type(), Atom.Type.Element);
        atom.set_type(Atom.Type.Dummy);
        assertEquals(atom.type(), Atom.Type.Dummy);
    }

    @Test public void properties() throws ChemfilesException {
        Atom atom = new Atom("He");
        assertEquals(atom.atomic_number(), 2);
        assertEquals(atom.vdw_radius(), 1.4, 1e-6);
        assertEquals(atom.covalent_radius(), 0.32, 1e-6);
    }
}
