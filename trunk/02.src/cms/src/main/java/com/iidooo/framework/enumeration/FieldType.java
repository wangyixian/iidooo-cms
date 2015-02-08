package com.iidooo.framework.enumeration;

/**
 * The field type and is mapping the DB data.
 * Do not change the sequence.
 * @author Ethan
 *
 */
public enum FieldType {
    // DB's data is start from 1, but the enumeration is start from 0, so add the None value.
    None,
    
    Text,
    
    Int,
    
    Float,
    
    TextArea,
    
    Date,
    
    Select,
    
    CheckBox,
    
    RadioBox,
}
