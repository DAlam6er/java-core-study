package com.basics.scopes.package_scope.inpackage;

public class ParentClass
{
    private boolean privateField = true;     // visible ONLY in ParentClass
    boolean defaultField = true;             // visible in package
    protected boolean protectedField = true; // visible in SubClass (both in package or out)
    public boolean publicField = true;       // visible everywhere

    protected void protectedMethod(){}

    private void privateMethod() {}

    public void publicMethod() {}
}
