/*
 *                        AT&T - PROPRIETARY
 *          THIS FILE CONTAINS PROPRIETARY INFORMATION OF
 *        AT&T AND IS NOT TO BE DISCLOSED OR USED EXCEPT IN
 *             ACCORDANCE WITH APPLICABLE AGREEMENTS.
 *
 *          Copyright (c) 2013 AT&T Knowledge Ventures
 *              Unpublished and Not for Publication
 *                     All Rights Reserved
 */
package com.att.research.xacml.std.jaxp;

import oasis.names.tc.xacml._3_0.core.schema.wd_17.StatusType;

import com.att.research.xacml.api.StatusCode;
import com.att.research.xacml.api.StatusDetail;
import com.att.research.xacml.std.StdMutableStatus;

/**
 * JaxpStatus extends {@link com.att.research.StdMutableStatus.common.std.StdStatus} with methods for creation from
 * JAXP elements.
 * 
 * @author car
 * @version $Revision: 1.1 $
 */
public class JaxpStatus extends StdMutableStatus {

	protected JaxpStatus(StatusCode statusCodeIn, String statusMessageIn, StatusDetail statusDetailIn) {
		super(statusCodeIn, statusMessageIn, statusDetailIn);
	}
	
	public static JaxpStatus newInstance(StatusType statusType) {
		if (statusType == null) {
			throw new NullPointerException("Null StatusType");
		} else if (statusType.getStatusCode() == null) {
			throw new IllegalArgumentException("Null StatusCode in StatusType");
		}
		StatusCode		statusCode		= JaxpStatusCode.newInstance(statusType.getStatusCode());
		StatusDetail	statusDetail	= null;
		if (statusType.getStatusDetail() != null) {
			statusDetail	= JaxpStatusDetail.newInstance(statusType.getStatusDetail());
		}
		
		return new JaxpStatus(statusCode, statusType.getStatusMessage(), statusDetail);
		
	}
}
