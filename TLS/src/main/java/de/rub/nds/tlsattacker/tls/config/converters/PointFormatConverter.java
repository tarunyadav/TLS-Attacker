/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2016 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.tls.config.converters;

import com.beust.jcommander.IStringConverter;
import com.beust.jcommander.ParameterException;
import de.rub.nds.tlsattacker.tls.constants.ECPointFormat;
import java.util.Arrays;

/**
 * Converts an EC point format string to an ECPointFormat (for command line
 * purposes).
 * 
 * @author Juraj Somorovsky <juraj.somorovsky@rub.de>
 */
public class PointFormatConverter implements IStringConverter<ECPointFormat> {

    @Override
    public ECPointFormat convert(String value) {

	try {
	    return ECPointFormat.valueOf(value);
	} catch (IllegalArgumentException e) {
	    throw new ParameterException("Value " + value + " cannot be converted to a ECPointFormat. "
		    + "Available values are: " + Arrays.toString(ECPointFormat.values()));
	}
    }
}
