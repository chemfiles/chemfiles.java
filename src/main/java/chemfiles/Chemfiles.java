package chemfiles;

import com.sun.jna.*;
import com.sun.jna.ptr.*;

class Chemfiles {
    static {
        Native.register("chemfiles");
    }

    public native static Pointer chfl_atom(String name);
    public native static int chfl_atom_free(Pointer atom);
    public native static int chfl_atom_name(Pointer atom, byte[] buffer, long size);
    public native static int chfl_atom_set_name(Pointer atom, String name);
    public native static int chfl_atom_mass(Pointer atom, FloatByReference charge);
    public native static int chfl_atom_set_mass(Pointer atom, float mass);
    public native static int chfl_atom_charge(Pointer atom, FloatByReference charge);
    public native static int chfl_atom_set_charge(Pointer atom, float charge);
}
