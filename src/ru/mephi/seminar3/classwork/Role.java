package ru.mephi.seminar3.classwork;

/**
 * Class of roles of people in the company.
 */
public enum Role {
    STAFF(0.1),
    MANAGER(0.2),
    EXECUTIVE(0.3);

    private final double value;

    /**
     * Assigning a different percentage to each role.
     *
     * @param value percentage of premium.
     */
    private Role(double value) {
        this.value = value;
    }

    /**
     * Get percentage of premium.
     *
     * @return <b>value</b>.
     */
    public double getValue() {
        return this.value;
    }
}