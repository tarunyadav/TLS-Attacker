/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2016 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.tls.constants;

import de.rub.nds.tlsattacker.tls.exceptions.ConfigurationException;
import de.rub.nds.tlsattacker.util.ArrayConverter;
import java.io.Serializable;

/**
 * Construction of a hash and signature algorithm.
 * 
 * Very confusing, consists of two bytes, the first is hash algorithm:
 * {HashAlgorithm, SignatureAlgorithm}
 * 
 * @author Juraj Somorovsky <juraj.somorovsky@rub.de>
 */
public class SignatureAndHashAlgorithm implements Serializable {

    private SignatureAlgorithm signatureAlgorithm;

    private HashAlgorithm hashAlgorithm;

    public SignatureAndHashAlgorithm() {

    }

    public SignatureAndHashAlgorithm(byte[] value) {
	if (value == null || value.length != 2) {
	    throw new ConfigurationException("SignatureAndHashAlgorithm always consists of two bytes, but found "
		    + ArrayConverter.bytesToHexString(value));
	}
	hashAlgorithm = HashAlgorithm.getHashAlgorithm(value[0]);
	signatureAlgorithm = SignatureAlgorithm.getSignatureAlgorithm(value[1]);
    }

    public SignatureAndHashAlgorithm(SignatureAlgorithm sigAlgorithm, HashAlgorithm hashAlgorithm) {
	this.signatureAlgorithm = sigAlgorithm;
	this.hashAlgorithm = hashAlgorithm;
    }

    public static SignatureAndHashAlgorithm getSignatureAndHashAlgorithm(byte[] value) {
	return new SignatureAndHashAlgorithm(value);
    }

    public byte[] getByteValue() {
	return new byte[] { hashAlgorithm.getValue(), signatureAlgorithm.getValue() };
    }

    public SignatureAlgorithm getSignatureAlgorithm() {
	return signatureAlgorithm;
    }

    public void setSignatureAlgorithm(SignatureAlgorithm signatureAlgorithm) {
	this.signatureAlgorithm = signatureAlgorithm;
    }

    public HashAlgorithm getHashAlgorithm() {
	return hashAlgorithm;
    }

    public void setHashAlgorithm(HashAlgorithm hashAlgorithm) {
	this.hashAlgorithm = hashAlgorithm;
    }

    public String getJavaName() {
	String hashAlgorithmName = hashAlgorithm.getJavaName().replace("-", "");
	String signatureAlgorithmName = signatureAlgorithm.getJavaName();
	return hashAlgorithmName + "with" + signatureAlgorithmName;
    }
}