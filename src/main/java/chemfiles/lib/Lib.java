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
    public native static CHFL_TRAJECTORY chfl_trajectory_open(String filename, byte mode);
    public native static CHFL_TRAJECTORY chfl_trajectory_with_format(String filename, byte mode, String format);
    public native static int chfl_trajectory_read(CHFL_TRAJECTORY file, CHFL_FRAME frame);
    public native static int chfl_trajectory_read_step(CHFL_TRAJECTORY file, long step, CHFL_FRAME frame);
    public native static int chfl_trajectory_write(CHFL_TRAJECTORY file, CHFL_FRAME frame);
    public native static int chfl_trajectory_set_topology(CHFL_TRAJECTORY file, CHFL_TOPOLOGY topology);
    public native static int chfl_trajectory_set_topology_file(CHFL_TRAJECTORY file, String filename);
    public native static int chfl_trajectory_set_topology_with_format(CHFL_TRAJECTORY file, String filename, String format);
    public native static int chfl_trajectory_set_cell(CHFL_TRAJECTORY file, CHFL_CELL cell);
    public native static int chfl_trajectory_nsteps(CHFL_TRAJECTORY file, LongByReference nsteps);
    public native static int chfl_trajectory_sync(CHFL_TRAJECTORY file);
    public native static int chfl_trajectory_close(CHFL_TRAJECTORY file);
    public native static CHFL_FRAME chfl_frame(long natoms);
    public native static int chfl_frame_atoms_count(CHFL_FRAME frame, LongByReference natoms);
    public native static int chfl_frame_positions(CHFL_FRAME frame, PointerByReference data, LongByReference size);
    public native static int chfl_frame_velocities(CHFL_FRAME frame, PointerByReference data, LongByReference size);
    public native static int chfl_frame_resize(CHFL_FRAME frame, long natoms);
    public native static int chfl_frame_add_velocities(CHFL_FRAME frame);
    public native static int chfl_frame_has_velocities(CHFL_FRAME frame, IntByReference has_velocities);
    public native static int chfl_frame_set_cell(CHFL_FRAME frame, CHFL_CELL cell);
    public native static int chfl_frame_set_topology(CHFL_FRAME frame, CHFL_TOPOLOGY topology);
    public native static int chfl_frame_step(CHFL_FRAME frame, LongByReference step);
    public native static int chfl_frame_set_step(CHFL_FRAME frame, long step);
    public native static int chfl_frame_guess_topology(CHFL_FRAME frame);
    public native static int chfl_frame_free(CHFL_FRAME frame);
    public native static CHFL_CELL chfl_cell(double a, double b, double c);
    public native static CHFL_CELL chfl_cell_triclinic(double a, double b, double c, double alpha, double beta, double gamma);
    public native static CHFL_CELL chfl_cell_from_frame(CHFL_FRAME frame);
    public native static int chfl_cell_volume(CHFL_CELL cell, DoubleByReference V);
    public native static int chfl_cell_lengths(CHFL_CELL cell, DoubleByReference a, DoubleByReference b, DoubleByReference c);
    public native static int chfl_cell_set_lengths(CHFL_CELL cell, double a, double b, double c);
    public native static int chfl_cell_angles(CHFL_CELL cell, DoubleByReference alpha, DoubleByReference beta, DoubleByReference gamma);
    public native static int chfl_cell_set_angles(CHFL_CELL cell, double alpha, double beta, double gamma);
    public native static int chfl_cell_matrix(CHFL_CELL cell, double[] matrix);
    public native static int chfl_cell_type(CHFL_CELL cell, IntByReference type);
    public native static int chfl_cell_set_type(CHFL_CELL cell, int type);
    public native static int chfl_cell_free(CHFL_CELL cell);
    public native static CHFL_TOPOLOGY chfl_topology();
    public native static CHFL_TOPOLOGY chfl_topology_from_frame(CHFL_FRAME frame);
    public native static int chfl_topology_atoms_count(CHFL_TOPOLOGY topology, LongByReference natoms);
    public native static int chfl_topology_append(CHFL_TOPOLOGY topology, CHFL_ATOM atom);
    public native static int chfl_topology_remove(CHFL_TOPOLOGY topology, long i);
    public native static int chfl_topology_isbond(CHFL_TOPOLOGY topology, long i, long j, IntByReference result);
    public native static int chfl_topology_isangle(CHFL_TOPOLOGY topology, long i, long j, long k, IntByReference result);
    public native static int chfl_topology_isdihedral(CHFL_TOPOLOGY topology, long i, long j, long k, long m, IntByReference result);
    public native static int chfl_topology_bonds_count(CHFL_TOPOLOGY topology, LongByReference nbonds);
    public native static int chfl_topology_angles_count(CHFL_TOPOLOGY topology, LongByReference nangles);
    public native static int chfl_topology_dihedrals_count(CHFL_TOPOLOGY topology, LongByReference ndihedrals);
    public native static int chfl_topology_bonds(CHFL_TOPOLOGY topology, long[] data, long nbonds);
    public native static int chfl_topology_angles(CHFL_TOPOLOGY topology, long[] data, long nangles);
    public native static int chfl_topology_dihedrals(CHFL_TOPOLOGY topology, long[] data, long ndihedrals);
    public native static int chfl_topology_add_bond(CHFL_TOPOLOGY topology, long i, long j);
    public native static int chfl_topology_remove_bond(CHFL_TOPOLOGY topology, long i, long j);
    public native static int chfl_topology_free(CHFL_TOPOLOGY topology);
    public native static CHFL_ATOM chfl_atom(String name);
    public native static CHFL_ATOM chfl_atom_from_frame(CHFL_FRAME frame, long idx);
    public native static CHFL_ATOM chfl_atom_from_topology(CHFL_TOPOLOGY topology, long idx);
    public native static int chfl_atom_mass(CHFL_ATOM atom, FloatByReference mass);
    public native static int chfl_atom_set_mass(CHFL_ATOM atom, float mass);
    public native static int chfl_atom_charge(CHFL_ATOM atom, FloatByReference charge);
    public native static int chfl_atom_set_charge(CHFL_ATOM atom, float charge);
    public native static int chfl_atom_name(CHFL_ATOM atom, byte[] name, long buffsize);
    public native static int chfl_atom_set_name(CHFL_ATOM atom, String name);
    public native static int chfl_atom_full_name(CHFL_ATOM atom, byte[] name, long buffsize);
    public native static int chfl_atom_vdw_radius(CHFL_ATOM atom, DoubleByReference radius);
    public native static int chfl_atom_covalent_radius(CHFL_ATOM atom, DoubleByReference radius);
    public native static int chfl_atom_atomic_number(CHFL_ATOM atom, IntByReference number);
    public native static int chfl_atom_type(CHFL_ATOM atom, IntByReference type);
    public native static int chfl_atom_set_type(CHFL_ATOM atom, int type);
    public native static int chfl_atom_free(CHFL_ATOM atom);
    public native static CHFL_SELECTION chfl_selection(String selection);
    public native static int chfl_selection_size(CHFL_SELECTION selection, LongByReference size);
    public native static int chfl_selection_evalutate(CHFL_SELECTION selection, CHFL_FRAME frame, LongByReference n_matches);
    public native static int chfl_selection_matches(CHFL_SELECTION selection, Match matches, long n_matches);
    public native static int chfl_selection_free(CHFL_SELECTION selection);
}
