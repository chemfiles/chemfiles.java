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

    Atom(CHFL_ATOM handle) {
        this.handle = handle;
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

    public String full_name() {
        byte[] buffer = new byte[128];
        Lib.chfl_atom_full_name(this.handle, buffer, buffer.length);
        return Native.toString(buffer);
    }

    public double vdw_radius() {
        DoubleByReference res = new DoubleByReference();
        Lib.chfl_atom_vdw_radius(this.handle, res);
        return res.getValue();
    }

    public double covalent_radius() {
        DoubleByReference res = new DoubleByReference();
        Lib.chfl_atom_covalent_radius(this.handle, res);
        return res.getValue();
    }

    public int atomic_number() {
        IntByReference res = new IntByReference();
        Lib.chfl_atom_atomic_number(this.handle, res);
        return res.getValue();
    }

    public Type type() {
        IntByReference res = new IntByReference();
        Lib.chfl_atom_type(this.handle, res);
        return Type.from_int(res.getValue());
    }

    public void set_type(Type type) {
        Lib.chfl_atom_set_type(this.handle, type.as_int());
    }

    protected void finalize() throws Throwable {
        Lib.chfl_atom_free(this.handle);
    }

    private CHFL_ATOM handle;
}
