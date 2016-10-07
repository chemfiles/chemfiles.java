package chemfiles;

import chemfiles.lib.Lib;
import chemfiles.lib.CHFL_ATOM;
import chemfiles.lib.CHFL_ATOM_TYPES;

import com.sun.jna.*;
import com.sun.jna.ptr.*;

public class Atom {
    public enum Type {
        Element(CHFL_ATOM_TYPES.CHFL_ATOM_ELEMENT),
        CoarseGrained(CHFL_ATOM_TYPES.CHFL_ATOM_COARSE_GRAINED),
        Dummy(CHFL_ATOM_TYPES.CHFL_ATOM_DUMMY),
        Undefined(CHFL_ATOM_TYPES.CHFL_ATOM_UNDEFINED);

        private int value;
        Type(int value) {
            this.value = value;
        }

        private static Type from_int(int value) {
            if (value == CHFL_ATOM_TYPES.CHFL_ATOM_ELEMENT) {
                return Element;
            } else if (value == CHFL_ATOM_TYPES.CHFL_ATOM_COARSE_GRAINED) {
                return CoarseGrained;
            } else if (value == CHFL_ATOM_TYPES.CHFL_ATOM_DUMMY) {
                return Dummy;
            } else if (value == CHFL_ATOM_TYPES.CHFL_ATOM_UNDEFINED) {
                return Undefined;
            } else {
                throw new IllegalArgumentException(
                    "Got bad value in Atom.Type constructor: " + value
                );
            }
        }

        private int as_int() {
            return this.value;
        }
    }

    public Atom(String name) {
        this.handle = Lib.chfl_atom(name);
    }

    public String name() throws ChemfilesException {
        byte[] buffer = new byte[128];
        Chemfiles.check(Lib.chfl_atom_name(this.handle, buffer, buffer.length));
        return Native.toString(buffer);
    }

    public void set_name(String name) throws ChemfilesException {
        Chemfiles.check(Lib.chfl_atom_set_name(this.handle, name));
    }

    public float mass() throws ChemfilesException {
        FloatByReference mass = new FloatByReference();
        Chemfiles.check(Lib.chfl_atom_mass(this.handle, mass));
        return mass.getValue();
    }

    public void set_mass(float mass) throws ChemfilesException {
        Chemfiles.check(Lib.chfl_atom_set_mass(this.handle, mass));
    }

    public float charge() throws ChemfilesException {
        FloatByReference charge = new FloatByReference();
        Chemfiles.check(Lib.chfl_atom_charge(this.handle, charge));
        return charge.getValue();
    }

    public void set_charge(float charge) throws ChemfilesException {
        Chemfiles.check(Lib.chfl_atom_set_charge(this.handle, charge));
    }

    public String full_name() throws ChemfilesException {
        byte[] buffer = new byte[128];
        Chemfiles.check(Lib.chfl_atom_full_name(this.handle, buffer, buffer.length));
        return Native.toString(buffer);
    }

    public double vdw_radius() throws ChemfilesException {
        DoubleByReference res = new DoubleByReference();
        Chemfiles.check(Lib.chfl_atom_vdw_radius(this.handle, res));
        return res.getValue();
    }

    public double covalent_radius() throws ChemfilesException {
        DoubleByReference res = new DoubleByReference();
        Chemfiles.check(Lib.chfl_atom_covalent_radius(this.handle, res));
        return res.getValue();
    }

    public int atomic_number() throws ChemfilesException {
        IntByReference res = new IntByReference();
        Chemfiles.check(Lib.chfl_atom_atomic_number(this.handle, res));
        return res.getValue();
    }

    public Type type() throws ChemfilesException {
        IntByReference res = new IntByReference();
        Chemfiles.check(Lib.chfl_atom_type(this.handle, res));
        return Type.from_int(res.getValue());
    }

    public void set_type(Type type) throws ChemfilesException {
        Chemfiles.check(Lib.chfl_atom_set_type(this.handle, type.as_int()));
    }

    protected void finalize() throws Throwable {
        Chemfiles.check(Lib.chfl_atom_free(this.handle));
    }

    private CHFL_ATOM handle;
}
