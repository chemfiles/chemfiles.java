import static org.junit.Assert.assertEquals;
import org.junit.Test;

import chemfiles.Atom;

public class AtomTest {
    @Test public void name() {
        Atom atom = new Atom("He");
        assertEquals(atom.name(), "He");
        atom.set_name("Zn");
        assertEquals(atom.name(), "Zn");
    }

    @Test public void mass() {
        Atom atom = new Atom("He");
        assertEquals(atom.mass(), 4.002602100, 1e-9);
        atom.set_mass(22);
        assertEquals(atom.mass(), 22, 1e-6);
    }

    @Test public void charge() {
        Atom atom = new Atom("He");
        assertEquals(atom.charge(), 0, 1e-9);
        atom.set_charge(-3.2f);
        assertEquals(atom.charge(), -3.2, 1e-6);
    }
}
