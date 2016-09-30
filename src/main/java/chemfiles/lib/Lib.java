// Chemfiles, an efficient IO library for chemistry file formats
// Copyright (C) 2015 Guillaume Fraux
//
// This Source Code Form is subject to the terms of the Mozilla Public
// License, v. 2.0. If a copy of the MPL was not distributed with this
// file, You can obtain one at http://mozilla.org/MPL/2.0/

/* ========================================================================= */
// !!!! AUTO-GENERATED FILE !!!! Do not edit. See the bindgen repository for
// the generation code (https://github.com/chemfiles/bindgen).
// This file contains Python ctype interface to the C API
/* ========================================================================= */

package chemfiles.lib;

import com.sun.jna.*;
import com.sun.jna.ptr.*;

import chemfiles.lib.Match;
import chemfiles.lib.LoggingCallback;

public class Lib {
    static {
        Native.register("chemfiles");
    }
    public native static String chfl_version();
    public native static String chfl_strerror(int status);
    public native static String chfl_last_error();
    public native static int chfl_clear_errors();
    public native static int chfl_loglevel(IntByReference level);
    public native static int chfl_set_loglevel(int level);
    public native static int chfl_logfile(String file);
    public native static int chfl_log_stdout();
    public native static int chfl_log_stderr();
    public native static int chfl_log_silent();
    public native static int chfl_log_callback(LoggingCallback callback);
    public native static Pointer chfl_trajectory_open(String filename, byte mode);
    public native static Pointer chfl_trajectory_with_format(String filename, byte mode, String format);
    public native static int chfl_trajectory_read(Pointer file, Pointer frame);
    public native static int chfl_trajectory_read_step(Pointer file, long step, Pointer frame);
    public native static int chfl_trajectory_write(Pointer file, Pointer frame);
    public native static int chfl_trajectory_set_topology(Pointer file, Pointer topology);
    public native static int chfl_trajectory_set_topology_file(Pointer file, String filename);
    public native static int chfl_trajectory_set_topology_with_format(Pointer file, String filename, String format);
    public native static int chfl_trajectory_set_cell(Pointer file, Pointer cell);
    public native static int chfl_trajectory_nsteps(Pointer file, LongByReference nsteps);
    public native static int chfl_trajectory_sync(Pointer file);
    public native static int chfl_trajectory_close(Pointer file);
    public native static Pointer chfl_frame(long natoms);
    public native static int chfl_frame_atoms_count(Pointer frame, LongByReference natoms);
    public native static int chfl_frame_positions(Pointer frame, PointerByReference data, LongByReference size);
    public native static int chfl_frame_velocities(Pointer frame, PointerByReference data, LongByReference size);
    public native static int chfl_frame_resize(Pointer frame, long natoms);
    public native static int chfl_frame_add_velocities(Pointer frame);
    public native static int chfl_frame_has_velocities(Pointer frame, IntByReference has_velocities);
    public native static int chfl_frame_set_cell(Pointer frame, Pointer cell);
    public native static int chfl_frame_set_topology(Pointer frame, Pointer topology);
    public native static int chfl_frame_step(Pointer frame, LongByReference step);
    public native static int chfl_frame_set_step(Pointer frame, long step);
    public native static int chfl_frame_guess_topology(Pointer frame);
    public native static int chfl_frame_free(Pointer frame);
    public native static Pointer chfl_cell(double a, double b, double c);
    public native static Pointer chfl_cell_triclinic(double a, double b, double c, double alpha, double beta, double gamma);
    public native static Pointer chfl_cell_from_frame(Pointer frame);
    public native static int chfl_cell_volume(Pointer cell, DoubleByReference V);
    public native static int chfl_cell_lengths(Pointer cell, DoubleByReference a, DoubleByReference b, DoubleByReference c);
    public native static int chfl_cell_set_lengths(Pointer cell, double a, double b, double c);
    public native static int chfl_cell_angles(Pointer cell, DoubleByReference alpha, DoubleByReference beta, DoubleByReference gamma);
    public native static int chfl_cell_set_angles(Pointer cell, double alpha, double beta, double gamma);
    public native static int chfl_cell_matrix(Pointer cell, double[] matrix);
    public native static int chfl_cell_type(Pointer cell, IntByReference type);
    public native static int chfl_cell_set_type(Pointer cell, int type);
    public native static int chfl_cell_free(Pointer cell);
    public native static Pointer chfl_topology();
    public native static Pointer chfl_topology_from_frame(Pointer frame);
    public native static int chfl_topology_atoms_count(Pointer topology, LongByReference natoms);
    public native static int chfl_topology_append(Pointer topology, Pointer atom);
    public native static int chfl_topology_remove(Pointer topology, long i);
    public native static int chfl_topology_isbond(Pointer topology, long i, long j, IntByReference result);
    public native static int chfl_topology_isangle(Pointer topology, long i, long j, long k, IntByReference result);
    public native static int chfl_topology_isdihedral(Pointer topology, long i, long j, long k, long m, IntByReference result);
    public native static int chfl_topology_bonds_count(Pointer topology, LongByReference nbonds);
    public native static int chfl_topology_angles_count(Pointer topology, LongByReference nangles);
    public native static int chfl_topology_dihedrals_count(Pointer topology, LongByReference ndihedrals);
    public native static int chfl_topology_bonds(Pointer topology, long[] data, long nbonds);
    public native static int chfl_topology_angles(Pointer topology, long[] data, long nangles);
    public native static int chfl_topology_dihedrals(Pointer topology, long[] data, long ndihedrals);
    public native static int chfl_topology_add_bond(Pointer topology, long i, long j);
    public native static int chfl_topology_remove_bond(Pointer topology, long i, long j);
    public native static int chfl_topology_free(Pointer topology);
    public native static Pointer chfl_atom(String name);
    public native static Pointer chfl_atom_from_frame(Pointer frame, long idx);
    public native static Pointer chfl_atom_from_topology(Pointer topology, long idx);
    public native static int chfl_atom_mass(Pointer atom, FloatByReference mass);
    public native static int chfl_atom_set_mass(Pointer atom, float mass);
    public native static int chfl_atom_charge(Pointer atom, FloatByReference charge);
    public native static int chfl_atom_set_charge(Pointer atom, float charge);
    public native static int chfl_atom_name(Pointer atom, byte[] name, long buffsize);
    public native static int chfl_atom_set_name(Pointer atom, String name);
    public native static int chfl_atom_full_name(Pointer atom, byte[] name, long buffsize);
    public native static int chfl_atom_vdw_radius(Pointer atom, DoubleByReference radius);
    public native static int chfl_atom_covalent_radius(Pointer atom, DoubleByReference radius);
    public native static int chfl_atom_atomic_number(Pointer atom, IntByReference number);
    public native static int chfl_atom_type(Pointer atom, IntByReference type);
    public native static int chfl_atom_set_type(Pointer atom, int type);
    public native static int chfl_atom_free(Pointer atom);
    public native static Pointer chfl_selection(String selection);
    public native static int chfl_selection_size(Pointer selection, LongByReference size);
    public native static int chfl_selection_evalutate(Pointer selection, Pointer frame, LongByReference n_matches);
    public native static int chfl_selection_matches(Pointer selection, Match matches, long n_matches);
    public native static int chfl_selection_free(Pointer selection);
}
