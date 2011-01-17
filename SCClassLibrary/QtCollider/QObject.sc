QObject {
  classvar
    < closeEvent = 19,
    < showEvent = 17,
    < windowActivateEvent = 24,
    < windowDeactivateEvent = 25,
    < mouseDownEvent = 2,
    < mouseUpEvent = 3,
    < mouseDblClickEvent = 4,
    < mouseMoveEvent = 5,
    < mouseOverEvent = 10,
    < keyDownEvent = 6,
    < keyUpEvent = 7;

  var qObject, finalizer;
  var virtualSlots;

  *new { arg className, argumentArray;
    ^super.new.initQObject( className, argumentArray );
  }

  initQObject{ arg className, argumentArray;
    _QObject_New
    ^this.primitiveFailed;
  }

  destroy {
    _QObject_Destroy
    ^this.primitiveFailed
  }

  isValid {
    ^qObject.notNil;
  }

  setParent { arg parent;
    _QObject_SetParent
    ^this.primitiveFailed
  }

  getProperty{ arg property, preAllocatedReturn;
    _QObject_GetProperty
    ^this.primitiveFailed
  }

  setProperty { arg property, value, direct=true;
    _QObject_SetProperty
    ^this.primitiveFailed
  }

  registerEventHandler{ arg event, method, direct=false;
    _QObject_SetEventHandler
    ^this.primitiveFailed
  }

  setSignalHandler { arg signal, handler, direct=false;
    _QObject_Connect
    ^this.primitiveFailed
  }

  connectToSlot { arg signal, receiver, slot;
    _QObject_ConnectToSlot;
    ^this.primitiveFailed
  }

  connectToFunction { arg signal, function, synchronous = false;
    virtualSlots = virtualSlots.add( function );
    this.prConnectToFunction( signal, function, synchronous );
  }

  invokeMethod { arg method, arguments, synchronous = false;
    _QObject_InvokeMethod
    ^this.primitiveFailed
  }

  ////////////////////// private //////////////////////////////////

  prConnectToFunction { arg signal, function, synchronous = false;
    _QObject_ConnectToFunction;
    ^this.primitiveFailed
  }

  doFunction { arg f ... args; f.value( this, args ); }

}
