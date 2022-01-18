package org.bouncycastle.pqc.asn1;


import org.bouncycastle.asn1.*;
import org.bouncycastle.util.Arrays;

/**
 *
 *    Classic McEliece Public Key Format
 *        McEliecePublicKey ::= SEQUENCE {
 *        T       OCTET STRING    -- public key
 *    }
 *
 */
public class CMCEPublicKey
    extends ASN1Object
{

    private byte[] T;

    public CMCEPublicKey(byte[] t)
    {
        this.T = t;
    }

    public CMCEPublicKey(ASN1Sequence seq)
    {
        T = Arrays.clone(((ASN1OctetString)seq.getObjectAt(0)).getOctets());
    }

    public byte[] getT()
    {
        return Arrays.clone(T);
    }

    public ASN1Primitive toASN1Primitive()
    {
        ASN1EncodableVector v = new ASN1EncodableVector();
        v.add(new DEROctetString(T));
        return new DERSequence(v);
    }
    public static  CMCEPublicKey getInstance(Object o)
    {
        if (o instanceof CMCEPrivateKey)
        {
            return (CMCEPublicKey) o;
        }
        else if (o != null)
        {
            return new CMCEPublicKey(ASN1Sequence.getInstance(o));
        }

        return null;
    }
}