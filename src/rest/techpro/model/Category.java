package rest.techpro.model;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Category {
	PC_FIXE, PC_PORTABLE, ACCESSOIRE_PC, TELEPHONE_FIXE, TELEPHONE_PORTABLE, ACCESSOIRE_TELEPHONE, 
	CLE_USB, DISQUE_DUR, ACCESSOIRE_STOCKAGE;
}
