package tss.tpm;

import tss.*;


// -----------This is an auto-generated file: do not edit

//>>>

/**
 *  This list is used to report the authorization policy values for permanent handles. This is
 *  list may be generated by TPM2_GetCapabiltiy(). A permanent handle that cannot have a
 *  policy is not included in the list.
 */
public class TPML_TAGGED_POLICY extends TpmStructure implements TPMU_CAPABILITIES 
{
    /** array of tagged policies */
    public TPMS_TAGGED_POLICY[] policies;
    
    public TPML_TAGGED_POLICY() {}
    
    /** @param _policies array of tagged policies */
    public TPML_TAGGED_POLICY(TPMS_TAGGED_POLICY[] _policies)
    {
        policies = _policies;
    }

    @Override
    public void toTpm(OutByteBuf buf) 
    {
        buf.writeInt(policies != null ? policies.length : 0, 4);
        if (policies != null)
            buf.writeArrayOfTpmObjects(policies);
    }

    @Override
    public void initFromTpm(InByteBuf buf)
    {
        int _count = buf.readInt(4);
        policies = new TPMS_TAGGED_POLICY[_count];
        for (int j=0; j < _count; j++) policies[j] = new TPMS_TAGGED_POLICY();
        buf.readArrayOfTpmObjects(policies, _count);
    }

    @Override
    public byte[] toTpm() 
    {
        OutByteBuf buf = new OutByteBuf();
        toTpm(buf);
        return buf.getBuf();
    }

    public static TPML_TAGGED_POLICY fromTpm (byte[] x) 
    {
        TPML_TAGGED_POLICY ret = new TPML_TAGGED_POLICY();
        InByteBuf buf = new InByteBuf(x);
        ret.initFromTpm(buf);
        if (buf.bytesRemaining()!=0)
            throw new AssertionError("bytes remaining in buffer after object was de-serialized");
        return ret;
    }

    public static TPML_TAGGED_POLICY fromTpm (InByteBuf buf) 
    {
        TPML_TAGGED_POLICY ret = new TPML_TAGGED_POLICY();
        ret.initFromTpm(buf);
        return ret;
    }

    @Override
    public String toString()
    {
        TpmStructurePrinter _p = new TpmStructurePrinter("TPML_TAGGED_POLICY");
        toStringInternal(_p, 1);
        _p.endStruct();
        return _p.toString();
    }

    @Override
    public void toStringInternal(TpmStructurePrinter _p, int d)
    {
        _p.add(d, "TPMS_TAGGED_POLICY", "policies", policies);
    }
}

//<<<

