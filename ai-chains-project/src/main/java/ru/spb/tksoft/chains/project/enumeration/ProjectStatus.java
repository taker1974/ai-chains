package ru.spb.tksoft.chains.project.enumeration;

import jakarta.validation.constraints.NotNull;

/**
 * Project status enumeration.
 * 
 * Defines possible states of a project in the system.
 * 
 * @author Konstantin Terskikh, kostus.online.1974@yandex.ru, 2025
 */
public enum ProjectStatus {

    /** Project status is unknown: not set, wrong value, etc. */
    UNKNOWN("UNKNOWN"),

    /** Project is ready for use. */
    READY("READY"),

    /** Project is being edited. */
    EDITING("EDITING"),

    /** Project has been deleted. */
    DELETED("DELETED"),

    /** Project has been rejected. */
    REJECTED("REJECTED");

    /** Status value. */
    private final String value;

    /**
     * Constructor.
     * 
     * @param value - status value
     */
    ProjectStatus(String value) {
        this.value = value;
    }

    /**
     * Get status value.
     * 
     * @return status value
     */
    public String getValue() {
        return value;
    }

    /**
     * Get ProjectStatus by value.
     * 
     * @param value - status value
     * @return ProjectStatus or UNKNOWN if not found
     */
    @NotNull
    public static ProjectStatus fromValue(String value) {
        for (ProjectStatus status : ProjectStatus.values()) {
            if (status.value.equals(value)) {
                return status;
            }
        }
        return ProjectStatus.UNKNOWN;
    }
}
