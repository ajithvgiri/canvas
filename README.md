[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-Drawing%20Library-green.svg?style=flat )]( https://android-arsenal.com/details/1/6403 ) [![](https://jitpack.io/v/ajithvgiri/canvas-library.svg)](https://jitpack.io/#ajithvgiri/canvas-library)

# Drawing App Library
Simple android library for drawing

![Drawing App](https://i.imgur.com/tNgmdNY.png)

# Setup
## 1. Provide the gradle dependency

Add it in your root build.gradle at the end of repositories:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

Add the gradle dependency to your `app` module `build.gradle` file:

```
	dependencies {
	        compile 'com.github.ajithvgiri:Canvas-Library:v1.1.1'
	}

```

## 2. Add the Canvas View view to your Relative Layout xml file

Make sure `layout_width` and `layout_height` are `match-parent`. and make sure the background of the layout must be white

``` xml
         <RelativeLayout
                android:id="@+id/parentView"
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:background="#FFFFFF" />
```

## 3. Add the canvas view to the layout

``` java
        RelativeLayout parentView = findViewById(R.id.parentView);
        CanvasView canvasView = new CanvasView(this);
        parentView.addView(canvasView);
```

To clear the drawing

``` java
        canvasView.clearCanvas();
```
