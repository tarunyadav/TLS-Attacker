/**
 * TLS-Attacker - A Modular Penetration Testing Framework for TLS
 *
 * Copyright 2014-2016 Ruhr University Bochum / Hackmanit GmbH
 *
 * Licensed under Apache License 2.0
 * http://www.apache.org/licenses/LICENSE-2.0
 */
package de.rub.nds.tlsattacker.dtls.protocol.handshake;

import de.rub.nds.tlsattacker.modifiablevariable.ModifiableVariableFactory;
import de.rub.nds.tlsattacker.modifiablevariable.ModifiableVariableProperty;
import de.rub.nds.tlsattacker.modifiablevariable.bytearray.ModifiableByteArray;
import de.rub.nds.tlsattacker.modifiablevariable.singlebyte.ModifiableByte;
import de.rub.nds.tlsattacker.tls.constants.ConnectionEnd;
import de.rub.nds.tlsattacker.tls.constants.ProtocolVersion;
import de.rub.nds.tlsattacker.tls.constants.HandshakeMessageType;
import de.rub.nds.tlsattacker.tls.protocol.handshake.HandshakeMessage;

/**
 * @author Florian Pfützenreuter <Florian.Pfuetzenreuter@rub.de>
 */
public class HelloVerifyRequestMessage extends HandshakeMessage {

    @ModifiableVariableProperty(type = ModifiableVariableProperty.Type.TLS_CONSTANT)
    ModifiableByteArray protocolVersion;

    @ModifiableVariableProperty(type = ModifiableVariableProperty.Type.LENGTH)
    ModifiableByte cookieLength;

    @ModifiableVariableProperty(type = ModifiableVariableProperty.Type.COOKIE)
    ModifiableByteArray cookie;

    public HelloVerifyRequestMessage() {
	super(HandshakeMessageType.HELLO_VERIFY_REQUEST);
	protocolVersion = ModifiableVariableFactory.safelySetValue(protocolVersion, ProtocolVersion.DTLS12.getValue());
	cookieLength = ModifiableVariableFactory.safelySetValue(cookieLength, (byte) 0);
	cookie = ModifiableVariableFactory.safelySetValue(cookie, new byte[0]);
    }

    public HelloVerifyRequestMessage(ConnectionEnd messageIssuer) {
	this();
	this.messageIssuer = messageIssuer;
    }

    public HelloVerifyRequestMessage(HandshakeMessageType handshakeMessageType) {
	super(handshakeMessageType);
    }

    public ModifiableByteArray getProtocolVersion() {
	return protocolVersion;
    }

    public ModifiableByteArray getCookie() {
	return cookie;
    }

    public ModifiableByte getCookieLength() {
	return cookieLength;
    }

    public void setProtocolVersion(byte[] protocolVersion) {
	this.protocolVersion = ModifiableVariableFactory.safelySetValue(this.protocolVersion, protocolVersion);
    }

    public void setProtocolVersion(ModifiableByteArray protocolVersion) {
	this.protocolVersion = protocolVersion;
    }

    public void setCookie(byte[] cookie) {
	this.cookie = ModifiableVariableFactory.safelySetValue(this.cookie, cookie);
    }

    public void setCookie(ModifiableByteArray cookie) {
	this.cookie = cookie;
    }

    public void setCookieLength(byte cookieLength) {
	this.cookieLength = ModifiableVariableFactory.safelySetValue(this.cookieLength, cookieLength);
    }

    public void setCookieLength(ModifiableByte cookieLength) {
	this.cookieLength = cookieLength;
    }
}
