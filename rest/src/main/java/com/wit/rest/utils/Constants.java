package com.wit.rest.utils;

public class Constants {
    public static final String SLASH = "/";

    public static class Operations {
        public static final String SUM = "sum";
        public static final String SUB = "sub";
        public static final String DIV = "div";
        public static final String MUL = "mul";
    }

    public static class RestOperations {
        public static final String SUM_OP = SLASH + Operations.SUM;
        public static final String SUB_OP = SLASH + Operations.SUB;
        public static final String DIV_OP = SLASH + Operations.DIV;
        public static final String MUL_OP = SLASH + Operations.MUL;
    }

    public static final String HEADER = "UUID";

    public static class Operands {
        public static final String OPERAND_ONE = "a";
        public static final String OPERAND_TWO = "b";

    }
}
