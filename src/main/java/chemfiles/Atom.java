package chemfiles;

import chemfiles.lib.Lib;
import com.sun.jna.Pointer;
import com.sun.jna.Native;
import com.sun.jna.ptr.FloatByReference;

public class Atom {
    public Atom(String name) {
        this.handle = Lib.chfl_atom(name);
    }

    public String name() {
        byte[] buffer = new byte[128];
        Lib.chfl_atom_name(this.handle, buffer, buffer.length);
        return Native.toString(buffer);
    }

    public void set_name(String name) {
        Lib.chfl_atom_set_name(this.handle, name);
    }

    public float mass() {
        FloatByReference mass = new FloatByReference();
        Lib.chfl_atom_mass(this.handle, mass);
        return mass.getValue();
    }

    public void set_mass(float mass) {
        Lib.chfl_atom_set_mass(this.handle, mass);
    }

    public float charge() {
        FloatByReference charge = new FloatByReference();
        Lib.chfl_atom_charge(this.handle, charge);
        return charge.getValue();
    }

    public void set_charge(float charge) {
        Lib.chfl_atom_set_charge(this.handle, charge);
    }

    protected void finalize() throws Throwable {
        Lib.chfl_atom_free(this.handle);
    }

    private Pointer handle;
}
