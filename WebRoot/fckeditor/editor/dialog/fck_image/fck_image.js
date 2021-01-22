/*
 * FCKeditor - The text editor for Internet - http://www.fckeditor.net
 * Copyright (C) 2003-2008 Frederico Caldeira Knabben
 *
 * == BEGIN LICENSE ==
 *
 * Licensed under the terms of any of the following licenses at your
 * choice:
 *
 *  - GNU General Public License Version 2 or later (the "GPL")
 *    http://www.gnu.org/licenses/gpl.html
 *
 *  - GNU Lesser General Public License Version 2.1 or later (the "LGPL")
 *    http://www.gnu.org/licenses/lgpl.html
 *
 *  - Mozilla Public License Version 1.1 or later (the "MPL")
 *    http://www.mozilla.org/MPL/MPL-1.1.html
 *
 * == END LICENSE ==
 *
 * Scripts related to the img dialog window (see fck_img.html).
 */

var dialog		= window.parent ;
var oEditor		= dialog.InnerDialogLoaded() ;
var FCK			= oEditor.FCK ;
var FCKLang		= oEditor.FCKLang ;
var FCKConfig	= oEditor.FCKConfig ;
var FCKDebug	= oEditor.FCKDebug ;
var FCKTools	= oEditor.FCKTools ;

var bimgButton = ( document.location.search.length > 0 && document.location.search.substr(1) == 'imgButton' ) ;

//#### Dialog Tabs

// Set the dialog tabs.
dialog.AddTab( 'Info', FCKLang.DlgImgInfoTab ) ;

if ( !bimgButton && !FCKConfig.imgDlgHideLink )
	dialog.AddTab( 'Link', FCKLang.DlgImgLinkTab ) ;

if ( FCKConfig.imgUpload )
	dialog.AddTab( 'Upload', FCKLang.DlgLnkUpload ) ;

if ( !FCKConfig.imgDlgHideAdvanced )
	dialog.AddTab( 'Advanced', FCKLang.DlgAdvancedTag ) ;

// Function called when a dialog tag is selected.
function OnDialogTabChange( tabCode )
{
	ShowE('divInfo'		, ( tabCode == 'Info' ) ) ;
	ShowE('divLink'		, ( tabCode == 'Link' ) ) ;
	ShowE('divUpload'	, ( tabCode == 'Upload' ) ) ;
	ShowE('divAdvanced'	, ( tabCode == 'Advanced' ) ) ;
}

// Get the selected img (if available).
var oimg = dialog.Selection.GetSelectedElement() ;

if ( oimg && oimg.tagName != 'IMG' && !( oimg.tagName == 'INPUT' && oimg.type == 'img' ) )
	oimg = null ;

// Get the active link.
var oLink = dialog.Selection.GetSelection().MoveToAncestorNode( 'A' ) ;

var oimgOriginal ;

function UpdateOriginal( resetSize )
{
	if ( !eImgPreview )
		return ;

	if ( GetE('txtUrl').value.length == 0 )
	{
		oimgOriginal = null ;
		return ;
	}

	oimgOriginal = document.createElement( 'IMG' ) ;	// new img() ;

	if ( resetSize )
	{
		oimgOriginal.onload = function()
		{
			this.onload = null ;
			ResetSizes() ;
		}
	}

	oimgOriginal.src = eImgPreview.src ;
}

var bPreviewInitialized ;

window.onload = function()
{
	// Translate the dialog box texts.
	oEditor.FCKLanguageManager.TranslatePage(document) ;

	GetE('btnLockSizes').title = FCKLang.DlgImgLockRatio ;
	GetE('btnResetSize').title = FCKLang.DlgBtnResetSize ;

	// Load the selected element information (if any).
	LoadSelection() ;

	// Show/Hide the "Browse Server" button.
	GetE('tdBrowse').style.display				= FCKConfig.imgBrowser	? '' : 'none' ;
	GetE('divLnkBrowseServer').style.display	= FCKConfig.LinkBrowser		? '' : 'none' ;

	UpdateOriginal() ;

	// Set the actual uploader URL.
	if ( FCKConfig.imgUpload )
		GetE('frmUpload').action = FCKConfig.imgUploadURL ;

	dialog.SetAutoSize( true ) ;

	// Activate the "OK" button.
	dialog.SetOkButton( true ) ;

	SelectField( 'txtUrl' ) ;
}

function LoadSelection()
{
	if ( ! oimg ) return ;

	var sUrl = oimg.getAttribute( '_fcksavedurl' ) ;
	if ( sUrl == null )
		sUrl = GetAttribute( oimg, 'src', '' ) ;

	GetE('txtUrl').value    = sUrl ;
	GetE('txtAlt').value    = GetAttribute( oimg, 'alt', '' ) ;
	GetE('txtVSpace').value	= GetAttribute( oimg, 'vspace', '' ) ;
	GetE('txtHSpace').value	= GetAttribute( oimg, 'hspace', '' ) ;
	GetE('txtBorder').value	= GetAttribute( oimg, 'border', '' ) ;
	GetE('cmbAlign').value	= GetAttribute( oimg, 'align', '' ) ;

	var iWidth, iHeight ;

	var regexSize = /^\s*(\d+)px\s*$/i ;

	if ( oimg.style.width )
	{
		var aMatchW  = oimg.style.width.match( regexSize ) ;
		if ( aMatchW )
		{
			iWidth = aMatchW[1] ;
			oimg.style.width = '' ;
			SetAttribute( oimg, 'width' , iWidth ) ;
		}
	}

	if ( oimg.style.height )
	{
		var aMatchH  = oimg.style.height.match( regexSize ) ;
		if ( aMatchH )
		{
			iHeight = aMatchH[1] ;
			oimg.style.height = '' ;
			SetAttribute( oimg, 'height', iHeight ) ;
		}
	}

	GetE('txtWidth').value	= iWidth ? iWidth : GetAttribute( oimg, "width", '' ) ;
	GetE('txtHeight').value	= iHeight ? iHeight : GetAttribute( oimg, "height", '' ) ;

	// Get Advances Attributes
	GetE('txtAttId').value			= oimg.id ;
	GetE('cmbAttLangDir').value		= oimg.dir ;
	GetE('txtAttLangCode').value	= oimg.lang ;
	GetE('txtAttTitle').value		= oimg.title ;
	GetE('txtLongDesc').value		= oimg.longDesc ;

	if ( oEditor.FCKBrowserInfo.IsIE )
	{
		GetE('txtAttClasses').value = oimg.className || '' ;
		GetE('txtAttStyle').value = oimg.style.cssText ;
	}
	else
	{
		GetE('txtAttClasses').value = oimg.getAttribute('class',2) || '' ;
		GetE('txtAttStyle').value = oimg.getAttribute('style',2) ;
	}

	if ( oLink )
	{
		var sLinkUrl = oLink.getAttribute( '_fcksavedurl' ) ;
		if ( sLinkUrl == null )
			sLinkUrl = oLink.getAttribute('href',2) ;

		GetE('txtLnkUrl').value		= sLinkUrl ;
		GetE('cmbLnkTarget').value	= oLink.target ;
	}

	UpdatePreview() ;
}

//#### The OK button was hit.
function Ok()
{
	if ( GetE('txtUrl').value.length == 0 )
	{
		dialog.SetSelectedTab( 'Info' ) ;
		GetE('txtUrl').focus() ;

		alert( FCKLang.DlgImgAlertUrl ) ;

		return false ;
	}

	var bHasimg = ( oimg != null ) ;

	if ( bHasimg && bimgButton && oimg.tagName == 'IMG' )
	{
		if ( confirm( 'Do you want to transform the selected img on a img button?' ) )
			oimg = null ;
	}
	else if ( bHasimg && !bimgButton && oimg.tagName == 'INPUT' )
	{
		if ( confirm( 'Do you want to transform the selected img button on a simple img?' ) )
			oimg = null ;
	}

	oEditor.FCKUndo.SaveUndoStep() ;
	if ( !bHasimg )
	{
		if ( bimgButton )
		{
			oimg = FCK.EditorDocument.createElement( 'input' ) ;
			oimg.type = 'img' ;
			oimg = FCK.InsertElement( oimg ) ;
		}
		else
			oimg = FCK.InsertElement( 'img' ) ;
	}

	Updateimg( oimg ) ;

	var sLnkUrl = GetE('txtLnkUrl').value.Trim() ;

	if ( sLnkUrl.length == 0 )
	{
		if ( oLink )
			FCK.ExecuteNamedCommand( 'Unlink' ) ;
	}
	else
	{
		if ( oLink )	// Modifying an existent link.
			oLink.href = sLnkUrl ;
		else			// Creating a new link.
		{
			if ( !bHasimg )
				oEditor.FCKSelection.SelectNode( oimg ) ;

			oLink = oEditor.FCK.CreateLink( sLnkUrl )[0] ;

			if ( !bHasimg )
			{
				oEditor.FCKSelection.SelectNode( oLink ) ;
				oEditor.FCKSelection.Collapse( false ) ;
			}
		}

		SetAttribute( oLink, '_fcksavedurl', sLnkUrl ) ;
		SetAttribute( oLink, 'target', GetE('cmbLnkTarget').value ) ;
	}

	return true ;
}

function Updateimg( e, skipId )
{
	e.src = GetE('txtUrl').value ;
	SetAttribute( e, "_fcksavedurl", GetE('txtUrl').value ) ;
	SetAttribute( e, "alt"   , GetE('txtAlt').value ) ;
	SetAttribute( e, "width" , GetE('txtWidth').value ) ;
	SetAttribute( e, "height", GetE('txtHeight').value ) ;
	SetAttribute( e, "vspace", GetE('txtVSpace').value ) ;
	SetAttribute( e, "hspace", GetE('txtHSpace').value ) ;
	SetAttribute( e, "border", GetE('txtBorder').value ) ;
	SetAttribute( e, "align" , GetE('cmbAlign').value ) ;

	// Advances Attributes

	if ( ! skipId )
		SetAttribute( e, 'id', GetE('txtAttId').value ) ;

	SetAttribute( e, 'dir'		, GetE('cmbAttLangDir').value ) ;
	SetAttribute( e, 'lang'		, GetE('txtAttLangCode').value ) ;
	SetAttribute( e, 'title'	, GetE('txtAttTitle').value ) ;
	SetAttribute( e, 'longDesc'	, GetE('txtLongDesc').value ) ;

	if ( oEditor.FCKBrowserInfo.IsIE )
	{
		e.className = GetE('txtAttClasses').value ;
		e.style.cssText = GetE('txtAttStyle').value ;
	}
	else
	{
		SetAttribute( e, 'class'	, GetE('txtAttClasses').value ) ;
		SetAttribute( e, 'style', GetE('txtAttStyle').value ) ;
	}
}

var eImgPreview ;
var eImgPreviewLink ;

function SetPreviewElements( imgElement, linkElement )
{
	eImgPreview = imgElement ;
	eImgPreviewLink = linkElement ;

	UpdatePreview() ;
	UpdateOriginal() ;

	bPreviewInitialized = true ;
}

function UpdatePreview()
{
	if ( !eImgPreview || !eImgPreviewLink )
		return ;

	if ( GetE('txtUrl').value.length == 0 )
		eImgPreviewLink.style.display = 'none' ;
	else
	{
		Updateimg( eImgPreview, true ) ;

		if ( GetE('txtLnkUrl').value.Trim().length > 0 )
			eImgPreviewLink.href = 'javascript:void(null);' ;
		else
			SetAttribute( eImgPreviewLink, 'href', '' ) ;

		eImgPreviewLink.style.display = '' ;
	}
}

var bLockRatio = true ;

function SwitchLock( lockButton )
{
	bLockRatio = !bLockRatio ;
	lockButton.className = bLockRatio ? 'BtnLocked' : 'BtnUnlocked' ;
	lockButton.title = bLockRatio ? 'Lock sizes' : 'Unlock sizes' ;

	if ( bLockRatio )
	{
		if ( GetE('txtWidth').value.length > 0 )
			OnSizeChanged( 'Width', GetE('txtWidth').value ) ;
		else
			OnSizeChanged( 'Height', GetE('txtHeight').value ) ;
	}
}

// Fired when the width or height input texts change
function OnSizeChanged( dimension, value )
{
	// Verifies if the aspect ration has to be maintained
	if ( oimgOriginal && bLockRatio )
	{
		var e = dimension == 'Width' ? GetE('txtHeight') : GetE('txtWidth') ;

		if ( value.length == 0 || isNaN( value ) )
		{
			e.value = '' ;
			return ;
		}

		if ( dimension == 'Width' )
			value = value == 0 ? 0 : Math.round( oimgOriginal.height * ( value  / oimgOriginal.width ) ) ;
		else
			value = value == 0 ? 0 : Math.round( oimgOriginal.width  * ( value / oimgOriginal.height ) ) ;

		if ( !isNaN( value ) )
			e.value = value ;
	}

	UpdatePreview() ;
}

// Fired when the Reset Size button is clicked
function ResetSizes()
{
	if ( ! oimgOriginal ) return ;
	if ( oEditor.FCKBrowserInfo.IsGecko && !oimgOriginal.complete )
	{
		setTimeout( ResetSizes, 50 ) ;
		return ;
	}

	GetE('txtWidth').value  = oimgOriginal.width ;
	GetE('txtHeight').value = oimgOriginal.height ;

	UpdatePreview() ;
}

function BrowseServer()
{
	OpenServerBrowser(
		'img',
		FCKConfig.imgBrowserURL,
		FCKConfig.imgBrowserWindowWidth,
		FCKConfig.imgBrowserWindowHeight ) ;
}

function LnkBrowseServer()
{
	OpenServerBrowser(
		'Link',
		FCKConfig.LinkBrowserURL,
		FCKConfig.LinkBrowserWindowWidth,
		FCKConfig.LinkBrowserWindowHeight ) ;
}

function OpenServerBrowser( type, url, width, height )
{
	sActualBrowser = type ;
	OpenFileBrowser( url, width, height ) ;
}

var sActualBrowser ;

function SetUrl( url, width, height, alt )
{
	if ( sActualBrowser == 'Link' )
	{
		GetE('txtLnkUrl').value = url ;
		UpdatePreview() ;
	}
	else
	{
		GetE('txtUrl').value = url ;
		GetE('txtWidth').value = width ? width : '' ;
		GetE('txtHeight').value = height ? height : '' ;

		if ( alt )
			GetE('txtAlt').value = alt;

		UpdatePreview() ;
		UpdateOriginal( true ) ;
	}

	dialog.SetSelectedTab( 'Info' ) ;
}

function OnUploadCompleted( errorNumber, fileUrl, fileName, customMsg )
{
	// Remove animation
	window.parent.Throbber.Hide() ;
	GetE( 'divUpload' ).style.display  = '' ;

	switch ( errorNumber )
	{
		case 0 :	// No errors
			alert( 'Your file has been successfully uploaded' ) ;
			break ;
		case 1 :	// Custom error
			alert( customMsg ) ;
			return ;
		case 101 :	// Custom warning
			alert( customMsg ) ;
			break ;
		case 201 :
			alert( 'A file with the same name is already available. The uploaded file has been renamed to "' + fileName + '"' ) ;
			break ;
		case 202 :
			alert( 'Invalid file type' ) ;
			return ;
		case 203 :
			alert( "Security error. You probably don't have enough permissions to upload. Please check your server." ) ;
			return ;
		case 500 :
			alert( 'The connector is disabled' ) ;
			break ;
		default :
			alert( 'Error on file upload. Error number: ' + errorNumber ) ;
			return ;
	}

	sActualBrowser = '' ;
	SetUrl( fileUrl ) ;
	GetE('frmUpload').reset() ;
}

var oUploadAllowedExtRegex	= new RegExp( FCKConfig.imgUploadAllowedExtensions, 'i' ) ;
var oUploadDeniedExtRegex	= new RegExp( FCKConfig.imgUploadDeniedExtensions, 'i' ) ;

function CheckUpload()
{
	var sFile = GetE('txtUploadFile').value ;

	if ( sFile.length == 0 )
	{
		alert( 'Please select a file to upload' ) ;
		return false ;
	}

	if ( ( FCKConfig.imgUploadAllowedExtensions.length > 0 && !oUploadAllowedExtRegex.test( sFile ) ) ||
		( FCKConfig.imgUploadDeniedExtensions.length > 0 && oUploadDeniedExtRegex.test( sFile ) ) )
	{
		OnUploadCompleted( 202 ) ;
		return false ;
	}

	// Show animation
	window.parent.Throbber.Show( 100 ) ;
	GetE( 'divUpload' ).style.display  = 'none' ;

	return true ;
}
