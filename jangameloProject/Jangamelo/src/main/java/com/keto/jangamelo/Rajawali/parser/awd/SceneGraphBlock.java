package com.keto.jangamelo.Rajawali.parser.awd;

import java.io.IOException;

import com.keto.jangamelo.Rajawali.parser.LoaderAWD.AWDLittleEndianDataInputStream;
import com.keto.jangamelo.Rajawali.parser.LoaderAWD.BlockHeader;
import com.keto.jangamelo.Rajawali.parser.ParsingException;
import com.keto.jangamelo.Rajawali.util.RajLog;

/**
 * 
 * @author Ian Thomas (toxicbakery@gmail.com)
 * 
 */
public class SceneGraphBlock {

	public final float[] transformMatrix = new float[16];

	public int parentID;
	public String lookupName;

	public void readGraphData(BlockHeader blockHeader, AWDLittleEndianDataInputStream awddis) throws IOException,
			ParsingException {
		// parent id, reference to previously defined object
		parentID = awddis.readInt();

		// Transformation matrix
		awddis.readMatrix3D(transformMatrix, blockHeader.globalPrecisionMatrix);

		// Lookup name
		lookupName = awddis.readVarString();
		RajLog.d("  Lookup Name: " + lookupName);
	}

}
