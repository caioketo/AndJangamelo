package com.keto.jangamelo.Rajawali.parser.awd;

import com.keto.jangamelo.Rajawali.parser.LoaderAWD.AWDLittleEndianDataInputStream;
import com.keto.jangamelo.Rajawali.parser.LoaderAWD.BlockHeader;
import com.keto.jangamelo.Rajawali.parser.awd.exceptions.NotImplementedParsingException;

/**
 * 
 * @author Ian Thomas (toxicbakery@gmail.com)
 * 
 */
public class BlockSkeleton extends ABlockParser {

	public void parseBlock(AWDLittleEndianDataInputStream dis, BlockHeader blockHeader) throws Exception {
		throw new NotImplementedParsingException();
	}

}
