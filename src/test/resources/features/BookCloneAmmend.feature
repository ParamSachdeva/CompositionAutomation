Feature: Execution Service Workflows - Book, Clone and Amend

	@BookCloneAmmendement
	Scenario Outline: <testcaseid> : <testcasedescription>
	 
	When "<tradeentrytype>" trade with given set of data,instrument type "<instrumenttype>"_"<tradebooktemplate>"_"<amendfield>"_"<amendvalue>"
	Then "<testcaseid>"_"<teststepid>" "<testcasedescription>","<testcasefile>"_"<testcasesheet>"_"<tradeentrytype>" tag name - "/discountingConvention"
	Then "<testcaseid>"_"<teststepid>" "<testcasedescription>","<testcasefile>"_"<testcasesheet>"_"<tradeentrytype>" tag name - "/analyticName"
	Then "<testcaseid>"_"<teststepid>" "<testcasedescription>","<testcasefile>"_"<testcasesheet>"_"<tradeentrytype>" tag name - "/curveName"
	Then "<testcaseid>"_"<teststepid>" "<testcasedescription>","<testcasefile>"_"<testcasesheet>"_"<tradeentrytype>" tag name - "/agreementClassification"
	Then "<testcaseid>"_"<teststepid>" "<testcasedescription>","<testcasefile>"_"<testcasesheet>"_"<tradeentrytype>" tag name - "/xvaBook"
	Then "<testcaseid>"_"<teststepid>" "<testcasedescription>","<testcasefile>"_"<testcasesheet>"_"<tradeentrytype>" tag name - "/xvaEligible"
	Then "<testcaseid>"_"<teststepid>" "<testcasedescription>","<testcasefile>"_"<testcasesheet>"_"<tradeentrytype>" tag name - "/isEnforceable"
	Then "<testcaseid>"_"<teststepid>" "<testcasedescription>","<testcasefile>"_"<testcasesheet>"_"<tradeentrytype>" tag name - "/isProductCovered"
	Then "<testcaseid>"_"<teststepid>" "<testcasedescription>","<testcasefile>"_"<testcasesheet>"_"<tradeentrytype>" tag name - "/nettingEntityReference"
	Then "<testcaseid>"_"<teststepid>" "<testcasedescription>","<testcasefile>"_"<testcasesheet>"_"<tradeentrytype>" tag name - "/transactionControl/ragStatus"
	Then "<testcaseid>"_"<teststepid>" "<testcasedescription>","<testcasefile>"_"<testcasesheet>"_"<tradeentrytype>" tag name - "/payVariationMarginEligible/regulatoryBody"
	Then "<testcaseid>"_"<teststepid>" "<testcasedescription>","<testcasefile>"_"<testcasesheet>"_"<tradeentrytype>" tag name - "/bcbs261RegulatoryMargin/receiveVariationMarginEligible/regulatoryBody"
	Then "<testcaseid>"_"<teststepid>" "<testcasedescription>","<testcasefile>"_"<testcasesheet>"_"<tradeentrytype>" tag name - "/bcbs261RegulatoryMargin/payInitialMarginEligible/regulatoryBody"
	Then "<testcaseid>"_"<teststepid>" "<testcasedescription>","<testcasefile>"_"<testcasesheet>"_"<tradeentrytype>" tag name - "/bcbs261RegulatoryMargin/receiveInitialMarginEligible/regulatoryBody"
	Then "<testcaseid>"_"<teststepid>" "<testcasedescription>","<testcasefile>"_"<testcasesheet>"_"<tradeentrytype>" tag name - "/masterAgreementReference"
	Then "<testcaseid>"_"<teststepid>" "<testcasedescription>","<testcasefile>"_"<testcasesheet>"_"<tradeentrytype>" tag name - "/agreementType"
	#Then "<testcaseid>"_"<teststepid>" "<testcasedescription>","<testcasefile>"_"<testcasesheet>"_"<tradeentrytype>" tag name - "/creditSupport[1]/creditSupportReference"
	#Then "<testcaseid>"_"<teststepid>" "<testcasedescription>","<testcasefile>"_"<testcasesheet>"_"<tradeentrytype>" tag name - "/creditSupport[2]/creditSupportReference"
	#Then "<testcaseid>"_"<teststepid>" "<testcasedescription>","<testcasefile>"_"<testcasesheet>"_"<tradeentrytype>" tag name - "/creditSupport[3]/creditSupportReference"
	Then "<testcaseid>"_"<teststepid>" "<testcasedescription>","<testcasefile>"_"<testcasesheet>"_"<tradeentrytype>" tag name - "/payInitialMargin/payInitialMarginReference"
	Then "<testcaseid>"_"<teststepid>" "<testcasedescription>","<testcasefile>"_"<testcasesheet>"_"<tradeentrytype>" tag name - "/receiveInitialMargin/receiveInitialMarginReference"
	Then "<testcaseid>"_"<teststepid>" "<testcasedescription>","<testcasefile>"_"<testcasesheet>"_"<tradeentrytype>" tag name - "/variationMargin/variationMarginReference"
	Then "<testcaseid>"_"<teststepid>" "<testcasedescription>","<testcasefile>"_"<testcasesheet>"_"<tradeentrytype>" tag name - "/variationMargin/displayName"
	Then "<testcaseid>"_"<teststepid>" "<testcasedescription>","<testcasefile>"_"<testcasesheet>"_"<tradeentrytype>" tag name - "/electedTermSet/variationMarginReference"
	Then "<testcaseid>"_"<teststepid>" "<testcasedescription>","<testcasefile>"_"<testcasesheet>"_"<tradeentrytype>" tag name - "/electedTermSet/payInitialMarginReference"
	Then "<testcaseid>"_"<teststepid>" "<testcasedescription>","<testcasefile>"_"<testcasesheet>"_"<tradeentrytype>" tag name - "/electedTermSet/receiveInitialMarginReference"
	
	
	
Examples:
|testcaseid			|teststepid | testcasedescription																				|instrumenttype|testcasefile			|testcasesheet|tradeentrytype|tradebooktemplate	|amendfield			|amendvalue|
|VT_FRA				|1			|Execution:Verify Composition Execution service tag value extracted corectly after booking trade	|FRA		   |BookCloneAmendTestCase	|BCA 	  	  |Book			 |BookFRA			|counterparty		|DEUT BK FFT|
|VT_FRA				|2			|Execution:Verify Composition Execution service tag value extracted corectly after cloaning trade	|FRA		   |BookCloneAmendTestCase	|BCA 	  	  |Clone		 |BookFRA			|counterparty		|DEUT BK FFT|
|VT_FRA				|3			|Execution:Verify Composition Execution service tag value extracted corectly after amending trade	|FRA		   |BookCloneAmendTestCase	|BCA 	  	  |Amend		 |AmendFRA			|counterparty 		|Nike Inc  	|
|VT_OIS     		|1			|Execution:Verify Composition Execution service tag value extracted corectly after booking trade	|OIS		   |BookCloneAmendTestCase	|BCA		  |Book			 |BookOIS			|SwapsWire			|enabled  	 |
|VT_OIS     		|2			|Execution:Verify Composition Execution service tag value extracted corectly after cloning trade	|OIS		   |BookCloneAmendTestCase	|BCA		  |Clone		 |BookOIS			|SwapsWire			|enabled  	 |
|VT_OIS     		|3			|Execution:Verify Composition Execution service tag value extracted corectly after amending trade	|OIS		   |BookCloneAmendTestCase	|BCA		  |Amend		 |AmendOIS			|SwapsWire			|disabled 	 |
|VT_SWAP    		|1			|Execution:Verify Composition Execution service tag value extracted corectly after booking trade	|Swap		   |BookCloneAmendTestCase	|BCA		  |Book			 |BookSwap			|clearingLocation	|CME-Interdealer		|
|VT_SWAP    		|2			|Execution:Verify Composition Execution service tag value extracted corectly after cloning trade	|Swap		   |BookCloneAmendTestCase	|BCA		  |Clone		 |BookSwap			|clearingLocation	|CME-Interdealer   		|
|VT_SWAP    		|3			|Execution:Verify Composition Execution service tag value extracted corectly after amending trade	|Swap		   |BookCloneAmendTestCase	|BCA		  |Amend		 |AmendSwap			|clearingLocation	|LCH UK SCM-InterDealer |
|VT_FXSWAP  		|1			|Execution:Verify Composition Execution service tag value extracted corectly after booking trade	|FXSwap	   	   |BookCloneAmendTestCase	|BCA		  |Book			 |BookFXSwap		|Far FX Rate		|1.3457	|
|VT_FXSWAP  		|2			|Execution:Verify Composition Execution service tag value extracted corectly after cloning trade	|FXSwap	   	   |BookCloneAmendTestCase	|BCA		  |Clone		 |BookFXSwap		|Far FX Rate		|1.3457	|
|VT_FXSWAP  		|3			|Execution:Verify Composition Execution service tag value extracted corectly after amending trade	|FXSwap	   	   |BookCloneAmendTestCase	|BCA		  |Amend		 |AmendFXSwap		|Far FX Rate		|2.3457	|
|VT_FXFW  	 		|1			|Execution:Verify Composition Execution service tag value extracted corectly after booking trade	|FXFW	   	   |BookCloneAmendTestCase	|BCA		  |Book			 |BookFXFW			|Fx Rate			|1.3457	|
|VT_FXFW    		|2			|Execution:Verify Composition Execution service tag value extracted corectly after cloning trade	|FXFW	   	   |BookCloneAmendTestCase	|BCA		  |Clone		 |BookFXFW			|Fx Rate			|1.3457	|
|VT_FXFW  	 		|3			|Execution:Verify Composition Execution service tag value extracted corectly after amending trade	|FXFW	   	   |BookCloneAmendTestCase	|BCA		  |Amend		 |AmendFXFW			|Fx Rate			|2.3457	|
|VT_CMSCAP  		|1			|Execution:Verify Composition Execution service tag value extracted corectly after booking trade	|CMSCAP	   	   |BookCloneAmendTestCase	|BCA		  |Book			 |BookCMSCAP		|notional			|1000000	|
|VT_CMSCAP  		|2			|Execution:Verify Composition Execution service tag value extracted corectly after cloning trade	|CMSCAP	   	   |BookCloneAmendTestCase	|BCA		  |Clone		 |BookCMSCAP		|notional			|1000000	|
|VT_CMSCAP  		|3			|Execution:Verify Composition Execution service tag value extracted corectly after amending trade	|CMSCAP	   	   |BookCloneAmendTestCase	|BCA		  |Amend		 |AmendCMSCAP		|notional			|2000000	|
|VT_CMSFLOOR  		|1			|Execution:Verify Composition Execution service tag value extracted corectly after booking trade	|CMSFLOOR  	   |BookCloneAmendTestCase	|BCA		  |Book			 |BookCMSFLOOR		|StrikeRate			|1.4826%	|
|VT_CMSFLOOR  		|2			|Execution:Verify Composition Execution service tag value extracted corectly after cloning trade	|CMSFLOOR  	   |BookCloneAmendTestCase	|BCA		  |Clone		 |BookCMSFLOOR		|StrikeRate			|1.4826%	|
|VT_CMSFLOOR  		|3			|Execution:Verify Composition Execution service tag value extracted corectly after amending trade	|CMSFLOOR  	   |BookCloneAmendTestCase	|BCA		  |Amend		 |AmendCMSFLOOR		|StrikeRate			|2.4826%	|
|VT_DIGICAP   		|1			|Execution:Verify Composition Execution service tag value extracted corectly after booking trade	|DIGICAP  	   |BookCloneAmendTestCase	|BCA		  |Book			 |BookDIGICAP		|counterparty		|NIKE INC	|
|VT_DIGICAP   		|2			|Execution:Verify Composition Execution service tag value extracted corectly after cloning trade	|DIGICAP  	   |BookCloneAmendTestCase	|BCA		  |Clone		 |BookDIGICAP		|counterparty		|NIKE INC	|
|VT_DIGICAP   		|3			|Execution:Verify Composition Execution service tag value extracted corectly after amending trade	|DIGICAP  	   |BookCloneAmendTestCase	|BCA		  |Amend		 |AmendDIGICAP		|counterparty		|DEUT BK FFT|
|VT_DIGIFLOOR 		|1			|Execution:Verify Composition Execution service tag value extracted corectly after booking trade	|DIGIFLOOR 	   |BookCloneAmendTestCase	|BCA		  |Book			 |BookDIGIFLOOR		|enddate			|20/07/2019	|
|VT_DIGIFLOOR 	 	|2			|Execution:Verify Composition Execution service tag value extracted corectly after cloning trade	|DIGIFLOOR 	   |BookCloneAmendTestCase	|BCA		  |Clone		 |BookDIGIFLOOR		|enddate			|24/07/2019	|
|VT_DIGIFLOOR  		|3			|Execution:Verify Composition Execution service tag value extracted corectly after amending trade	|DIGIFLOOR 	   |BookCloneAmendTestCase	|BCA		  |Amend		 |AmendDIGIFLOOR	|enddate			|24/07/2020 |
|VT_LOANDEPOSIT		|1			|Execution:Verify Composition Execution service tag value extracted corectly after booking trade	|LOANDEPOSIT   |BookCloneAmendTestCase	|BCA		  |Book			 |BookLOANDEPOSIT	|Payment Frequency	|6m			|
|VT_LOANDEPOSIT 	|2			|Execution:Verify Composition Execution service tag value extracted corectly after cloning trade	|LOANDEPOSIT   |BookCloneAmendTestCase	|BCA		  |Clone		 |BookLOANDEPOSIT	|Payment Frequency	|6m			|
|VT_LOANDEPOSIT 	|3			|Execution:Verify Composition Execution service tag value extracted corectly after amending trade	|LOANDEPOSIT   |BookCloneAmendTestCase	|BCA		  |Amend		 |AmendLOANDEPOSIT	|Payment Frequency	|9m			|
|VT_LOANDEPOSIT_T 	|1			|Execution:Verify Composition Execution service tag value extracted corectly after booking trade	|LOANDEPOSIT_T |BookCloneAmendTestCase	|BCA		  |Book			 |BookLOANDEPOSIT_T	|Payment Frequency	|6m			|
|VT_LOANDEPOSIT_T 	|2			|Execution:Verify Composition Execution service tag value extracted corectly after cloning trade	|LOANDEPOSIT_T |BookCloneAmendTestCase	|BCA		  |Clone		 |BookLOANDEPOSIT_T	|Payment Frequency	|6m			|
|VT_LOANDEPOSIT_T 	|3			|Execution:Verify Composition Execution service tag value extracted corectly after amending trade	|LOANDEPOSIT_T |BookCloneAmendTestCase	|BCA		  |Amend		 |AmendLOANDEPOSIT_T|Payment Frequency	|3m			|
|VT_LOANDEPOSITIRS	|1			|Execution:Verify Composition Execution service tag value extracted corectly after booking trade	|LOANDEPOSITIRS|BookCloneAmendTestCase	|BCA		  |Book			 |BookLOANDEPOSITIRS|currency			|GBP		|
|VT_LOANDEPOSITIRS  |2			|Execution:Verify Composition Execution service tag value extracted corectly after cloning trade	|LOANDEPOSITIRS|BookCloneAmendTestCase	|BCA		  |Clone		 |BookLOANDEPOSITIRS|currency			|GBP		|
|VT_LOANDEPOSITIRS  |3			|Execution:Verify Composition Execution service tag value extracted corectly after amending trade	|LOANDEPOSITIRS|BookCloneAmendTestCase	|BCA		  |Amend		 |AmendLOANDEPOSITIRS|currency			|USD		|
|VT_INFLATIONSWAP 	|1			|Execution:Verify Composition Execution service tag value extracted corectly after booking trade	|INFLATIONSWAP |BookCloneAmendTestCase	|BCA		  |Book			 |BookINFLATIONSWAP	|counterparty		|DEUT BK FFT|
|VT_INFLATIONSWAP 	|2			|Execution:Verify Composition Execution service tag value extracted corectly after cloning trade	|INFLATIONSWAP |BookCloneAmendTestCase	|BCA		  |Clone		 |BookINFLATIONSWAP	|counterparty		|DEUT BK FFT|
|VT_INFLATIONSWAP 	|3			|Execution:Verify Composition Execution service tag value extracted corectly after amending trade	|INFLATIONSWAP |BookCloneAmendTestCase	|BCA		  |Amend		 |AmendINFLATIONSWAP|counterparty		|LGIM 5958	|
|VT_FFSWAP 			|1			|Execution:Verify Composition Execution service tag value extracted corectly after booking trade	|FFSWAP	 	   |BookCloneAmendTestCase	|BCA		  |Book			 |BookFFSWAP		|cutoff		 		|0			|
|VT_FFSWAP 			|2			|Execution:Verify Composition Execution service tag value extracted corectly after cloning trade	|FFSWAP 	   |BookCloneAmendTestCase	|BCA		  |Clone		 |BookFFSWAP		|cutoff		 		|0			|
|VT_FFSWAP 			|3			|Execution:Verify Composition Execution service tag value extracted corectly after amending trade	|FFSWAP  	   |BookCloneAmendTestCase	|BCA		  |Amend		 |AmendFFSWAP		|cutoff      		|2			|
|VT_EUROSWAPTION	|1			|Execution:Verify Composition Execution service tag value extracted corectly after booking trade	|EUROSWAPTION  |BookCloneAmendTestCase	|BCA		  |Book			 |BookEUROSWAPTION	|clearingLocation	|CME-Interdealer |
|VT_EUROSWAPTION	|2			|Execution:Verify Composition Execution service tag value extracted corectly after cloning trade	|EUROSWAPTION  |BookCloneAmendTestCase	|BCA		  |Clone		 |BookEUROSWAPTION	|clearingLocation	|CME-Interdealer |
|VT_EUROSWAPTION	|3			|Execution:Verify Composition Execution service tag value extracted corectly after amending trade	|EUROSWAPTION  |BookCloneAmendTestCase	|BCA		  |Amend		 |AmendEUROSWAPTION	|clearingLocation	|None			 |
#|VT_ZEROCOUPONINSWAP|1			|Execution:Verify Composition Execution service tag value extracted corectly after booking trade	|ZEROCOUPONINSWAP  |BookCloneAmendTestCase	|BCA		  |Book			 |BookZEROCOUPONINSWAP	|clearingLocation	|LCH UK SCM-InterDealer |
#|VT_ZEROCOUPONINSWAP|2			|Execution:Verify Composition Execution service tag value extracted corectly after cloning trade	|ZEROCOUPONINSWAP  |BookCloneAmendTestCase	|BCA		  |Clone		 |BookZEROCOUPONINSWAP	|clearingLocation	|LCH UK SCM-InterDealer |
#|VT_ZEROCOUPONINSWAP|3			|Execution:Verify Composition Execution service tag value extracted corectly after amending trade	|ZEROCOUPONINSWAP  |BookCloneAmendTestCase	|BCA		  |Amend		 |AmendZEROCOUPONINSWAP	|clearingLocation	|None			 |
|VT_XCCYVANILA		|1			|Execution:Verify Composition Execution service tag value extracted corectly after booking trade	|XCCYVANILA  |BookCloneAmendTestCase	|BCA		  |Book			 |BookXCCYVANILA	|Broker		|salesteam 			|
|VT_XCCYVANILA		|2			|Execution:Verify Composition Execution service tag value extracted corectly after cloning trade	|XCCYVANILA  |BookCloneAmendTestCase	|BCA		  |Clone		 |BookXCCYVANILA	|Broker		|salesteam 			|
|VT_XCCYVANILA		|3			|Execution:Verify Composition Execution service tag value extracted corectly after amending trade	|XCCYVANILA  |BookCloneAmendTestCase	|BCA		  |Amend		 |AmendXCCYVANILA	|Broker		|BGC LDN			|
|VT_XCCYBASIS		|1			|Execution:Verify Composition Execution service tag value extracted corectly after booking trade	|XCCYBASIS 	 |BookCloneAmendTestCase	|BCA		  |Book			 |BookXCCYBASIS		|Notional	|100,000,000.0000	|
|VT_XCCYBASIS		|2			|Execution:Verify Composition Execution service tag value extracted corectly after cloning trade	|XCCYBASIS 	 |BookCloneAmendTestCase	|BCA		  |Clone		 |BookXCCYBASIS		|Notional	|100,000,000.0000	|
|VT_XCCYBASIS		|3			|Execution:Verify Composition Execution service tag value extracted corectly after amending trade	|XCCYBASIS 	 |BookCloneAmendTestCase	|BCA		  |Amend		 |AmendXCCYBASIS	|Notional	|200,000,000.0000 	|
|VT_XCCYMTM			|1			|Execution:Verify Composition Execution service tag value extracted corectly after booking trade	|XCCYMTM	 |BookCloneAmendTestCase	|BCA		  |Book			 |BookXCCYMTM		|fixrate	|0.9044%%		|
|VT_XCCYMTM			|2			|Execution:Verify Composition Execution service tag value extracted corectly after cloning trade	|XCCYMTM  	 |BookCloneAmendTestCase	|BCA		  |Clone		 |BookXCCYMTM		|fixrate	|0.9044%%		|
|VT_XCCYMTM			|3			|Execution:Verify Composition Execution service tag value extracted corectly after amending trade	|XCCYMTM  	 |BookCloneAmendTestCase	|BCA		  |Amend		 |AmendXCCYMTM		|fixrate	|1.9044%		|
|VT_STUBXML			|1			|Execution:Verify Composition Execution service tag value extracted corectly after booking trade	|STUBXML	 |BookCloneAmendTestCase	|BCA		  |Book			 |BookSTUBXML		|CAF pricer CAF instrument type	|FXTarnTrigger,PRDC|
|VT_STUBXML			|2			|Execution:Verify Composition Execution service tag value extracted corectly after cloning trade	|STUBXML  	 |BookCloneAmendTestCase	|BCA		  |Clone		 |BookSTUBXML		|CAF pricer CAF instrument type	|FXTarnTrigger,PRDC|
|VT_STUBXML			|3			|Execution:Verify Composition Execution service tag value extracted corectly after amending trade	|STUBXML  	 |BookCloneAmendTestCase	|BCA		  |Amend		 |AmendSTUBXML		|CAF pricer CAF instrument type	| Dymanic index option|
|VT_IRS_B			|1			|Execution:Verify Composition Execution service tag value extracted corectly after booking trade	|IRS_B		 |BookCloneAmendTestCase	|BCA		  |Book			 |BookIRS_B		|setupSwapsWire		|true	   |
|VT_IRS_B			|2			|Execution:Verify Composition Execution service tag value extracted corectly after cloning trade	|IRS_B  	 |BookCloneAmendTestCase	|BCA		  |Clone		 |BookIRS_B		|setupSwapsWire		|true	   |
|VT_IRS_B			|3			|Execution:Verify Composition Execution service tag value extracted corectly after amending trade	|IRS_B  	 |BookCloneAmendTestCase	|BCA		  |Amend		 |AmendIRS_B	|setupSwapsWire		|false	   |