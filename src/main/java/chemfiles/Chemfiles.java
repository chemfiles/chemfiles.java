package chemfiles;
import chemfiles.lib.Lib;
import chemfiles.lib.CHFL_LOG_LEVEL;

import com.sun.jna.*;
import com.sun.jna.ptr.*;

public class Chemfiles {
    public enum LogLevel {
        Error(CHFL_LOG_LEVEL.CHFL_LOG_ERROR),
        Warning(CHFL_LOG_LEVEL.CHFL_LOG_WARNING),
        Info(CHFL_LOG_LEVEL.CHFL_LOG_INFO),
        Debug(CHFL_LOG_LEVEL.CHFL_LOG_DEBUG);

        private int value;
        LogLevel(int value) {
            this.value = value;
        }

        private static LogLevel from_int(int value) {
            if (value == CHFL_LOG_LEVEL.CHFL_LOG_ERROR) {
                return Error;
            } else if (value == CHFL_LOG_LEVEL.CHFL_LOG_WARNING) {
                return Warning;
            } else if (value == CHFL_LOG_LEVEL.CHFL_LOG_INFO) {
                return Info;
            } else if (value == CHFL_LOG_LEVEL.CHFL_LOG_DEBUG) {
                return Debug;
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

    static void check(int status) throws ChemfilesException {
        if (status != 0) {
            throw new ChemfilesException(Lib.chfl_last_error());
        }
    }

    public static String version() {
        return Lib.chfl_version();
    }

    public static void clear_errors() throws ChemfilesException {
        Chemfiles.check(Lib.chfl_clear_errors());
    }

    public static LogLevel log_level() throws ChemfilesException {
        IntByReference level = new IntByReference();
        Chemfiles.check(Lib.chfl_loglevel(level));
        return LogLevel.from_int(level.getValue());
    }

    public static void set_log_level(LogLevel level) throws ChemfilesException {
        Chemfiles.check(Lib.chfl_set_loglevel(level.as_int()));
    }

    public static void log_file(String file) throws ChemfilesException {
        Chemfiles.check(Lib.chfl_logfile(file));
    }

    public static void log_stdout() throws ChemfilesException {
        Chemfiles.check(Lib.chfl_log_stdout());
    }

    public static void log_stderr() throws ChemfilesException {
        Chemfiles.check(Lib.chfl_log_stderr());
    }

    public static void log_silent() throws ChemfilesException {
        Chemfiles.check(Lib.chfl_log_silent());
    }

    // TODO: chfl_log_callback
}
