package chemfiles;

import chemfiles.Chemfiles;
import com.sun.jna.Pointer;
import com.sun.jna.Native;
import com.sun.jna.ptr.FloatByReference;

public class Atom {
    public Atom(String name) {
        this.handle = Chemfiles.chfl_atom(name);
    }

    public String name() {
        byte[] buffer = new byte[128];
        Chemfiles.chfl_atom_name(this.handle, buffer, buffer.length);
        return Native.toString(buffer);
    }

    public void set_name(String name) {
        Chemfiles.chfl_atom_set_name(this.handle, name);
    }

    public float mass() {
        FloatByReference mass = new FloatByReference();
        Chemfiles.chfl_atom_mass(this.handle, mass);
        return mass.getValue();
    }

    public void set_mass(float mass) {
        Chemfiles.chfl_atom_set_mass(this.handle, mass);
    }

    public float charge() {
        FloatByReference charge = new FloatByReference();
        Chemfiles.chfl_atom_charge(this.handle, charge);
        return charge.getValue();
    }

    public void set_charge(float charge) {
        Chemfiles.chfl_atom_set_charge(this.handle, charge);
    }

    protected void finalize() throws Throwable {
        Chemfiles.chfl_atom_free(this.handle);
    }

    private Pointer handle;
}
