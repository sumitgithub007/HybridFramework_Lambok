package enumPackage;

public enum WaitStrategy {
    /**
     * Wait until element is enabled.
     */
    ENABLED,
    /**
     * No wait.
     */
    NONE,
    /**
     * Wait until element is present.
     */
    PRESENT,
    /**
     * Wait until element is displayed.
     */
    VISIBLE
}