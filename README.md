## Quick note
Sadly I do not have the time to maintain the code any longer. Additionally I have not worked with Android for quite some time now. If you want to have a backport of the switch, please have a look at this project: https://github.com/Prototik/HoloEverywhere


##Switch for Froyo, Gingerbread & Honeycomb##
A little while ago I started my own custom Switch button for Gingerbread. I wanted to have a switch button that always displays the texts on the left and right side. Since the standard Switch only shows the text from the currently selected side, I had to code my own version, which you can check out here: http://ankri.de/switch-button-for-android-2-3-gingerbread/

Unfortunately it isn't perfect. You cannot disable it for example, because I didn't need it in my use case. After I got some feedback, I decided to do a complete backport of the original Switch button, which was fairly easy! I just copied the code and edited some lines.

I present to you the backport of the Switch button. Which has two minor limitations
* the accessibility functionality doesn't work with the Switch
* the Switch does not have RTL support

### Minor bug ###
Yeah. Unfortunately there is a minor bug aswell. For some reason the <code>OnCheckedChangeListener</code> is only called when the Switch has an <code>OnClickListener</code>. As a workaround I added an <code>OnClickListener</code> in the constructor of the Switch, so you don't have to worry about it.

## Usage ##
There are two projects. The <code>library</code> and the <code>demo</code> project. You can use the <code>library</code> project just like any other library project.

Just download the project. If you’re using the Eclipse Development Environment with the ADT plugin version 0.9.7 or greater you can include the SwitchCompatLibrary as a library project. Create a new Android project in Eclipse using the SwitchCompatLibrary folder as the existing source.
Then go to your project and in your project properties, add the created project under the ‘Libraries’ section of the ‘Android’ category.

To use the Switch you have to configure your theme. There are several ways!
<h3>1. When not using any custom theme</h3>
Go to your <code>AndroidManifest.xml</code> and edit the theme to this line:
<pre class="lang:xhtml decode:true">android:theme="@style/AppThemeDark"</pre>
for the <strong>dark</strong> theme or to:
<pre class="lang:xhtml decode:true">android:theme="@style/AppThemeLight"</pre>
for the <strong>light</strong> theme.
<h3>2. When using a custom theme</h3>
Go to your <code>styles.xml</code> and make either <code>AppThemeDark</code> or <code>AppThemeLight</code> the parent theme:
<pre class="lang:xhtml decode:true">&lt;style name="AppTheme" parent="AppThemeLight" /&gt;</pre>
<h3>3. When using a custom theme and depending on a different parent like <code>ActionBarSherlock</code></h3>
Add the two lines to the style your <code>styles.xml</code> for the <b>light</b> theme
<pre class="lang:xhtml decode:true ">&lt;style name="AppTheme" parent="Theme.Sherlock.Light"&gt;
  &lt;item name="switchStyle"&gt;@style/switch_light&lt;/item&gt;
	&lt;item name="textAppearance"&gt;@style/TextAppearance&lt;/item&gt;
&lt;/style&gt;</pre>
&nbsp;
Or add the two lines to the style your <code>styles.xml</code> for the <b>dark</b> theme
<pre class="lang:xhtml decode:true ">&lt;style name="AppTheme" parent="Theme.Sherlock"&gt;
	&lt;item name="switchStyle"&gt;@style/switch_dark&lt;/item&gt;
	&lt;item name="textAppearance"&gt;@style/TextAppearance&lt;/item&gt;
&lt;/style&gt;</pre>
&nbsp;
