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
 * FCKIcon Class: renders an icon from a single img, a strip or even a
 * spacer.
 */

var FCKIcon = function( iconPathOrStripInfoArray )
{
	var sTypeOf = iconPathOrStripInfoArray ? typeof( iconPathOrStripInfoArray ) : 'undefined' ;
	switch ( sTypeOf )
	{
		case 'number' :
			this.Path = FCKConfig.SkinPath + 'fck_strip.gif' ;
			this.Size = 16 ;
			this.Position = iconPathOrStripInfoArray ;
			break ;

		case 'undefined' :
			this.Path = FCK_SPACER_PATH ;
			break ;

		case 'string' :
			this.Path = iconPathOrStripInfoArray ;
			break ;

		default :
			// It is an array in the format [ StripFilePath, IconSize, IconPosition ]
			this.Path		= iconPathOrStripInfoArray[0] ;
			this.Size		= iconPathOrStripInfoArray[1] ;
			this.Position	= iconPathOrStripInfoArray[2] ;
	}
}

FCKIcon.prototype.CreateIconElement = function( document )
{
	var eIcon, eIconimg ;

	if ( this.Position )		// It is using an icons strip img.
	{
		var sPos = '-' + ( ( this.Position - 1 ) * this.Size ) + 'px' ;

		if ( FCKBrowserInfo.IsIE )
		{
			// <div class="TB_Button_img"><img src="strip.gif" style="top:-16px"></div>

			eIcon = document.createElement( 'DIV' ) ;

			eIconimg = eIcon.appendChild( document.createElement( 'IMG' ) ) ;
			eIconimg.src = this.Path ;
			eIconimg.style.top = sPos ;
		}
		else
		{
			// <img class="TB_Button_img" src="spacer.gif" style="background-position: 0px -16px;background-img: url(strip.gif);">

			eIcon = document.createElement( 'IMG' ) ;
			eIcon.src = FCK_SPACER_PATH ;
			eIcon.style.backgroundPosition	= '0px ' + sPos ;
			eIcon.style.backgroundimg		= 'url("' + this.Path + '")' ;
		}
	}
	else					// It is using a single icon img.
	{
		if ( FCKBrowserInfo.IsIE )
		{
			// IE makes the button 1px higher if using the <img> directly, so we
			// are changing to the <div> system to clip the img correctly.
			eIcon = document.createElement( 'DIV' ) ;

			eIconimg = eIcon.appendChild( document.createElement( 'IMG' ) ) ;
			eIconimg.src = this.Path ? this.Path : FCK_SPACER_PATH ;
		}
		else
		{
			// This is not working well with IE. See notes above.
			// <img class="TB_Button_img" src="smiley.gif">
			eIcon = document.createElement( 'IMG' ) ;
			eIcon.src = this.Path ? this.Path : FCK_SPACER_PATH ;
		}
	}

	eIcon.className = 'TB_Button_img' ;

	return eIcon ;
}
