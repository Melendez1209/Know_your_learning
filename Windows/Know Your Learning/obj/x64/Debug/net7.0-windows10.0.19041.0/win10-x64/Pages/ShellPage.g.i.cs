// Updated by XamlIntelliSenseFileGenerator 23/3/4 上午 09:29:43
#pragma checksum "D:\Codes\Know_your_learning\Windows\Know Your Learning\Pages\ShellPage.xaml" "{8829d00f-11b8-4213-878b-770e8597ac16}" "842006485B7989CB324ED31117ECB66D953B73EC529162AEF1FACA6E784030BB"
//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated by a tool.
//
//     Changes to this file may cause incorrect behavior and will be lost if
//     the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace Know_Your_Learning.Views
{
    partial class ShellPage : global::Microsoft.UI.Xaml.Controls.Page
    {
#pragma warning restore 0649
#pragma warning restore 0169
        [global::System.CodeDom.Compiler.GeneratedCodeAttribute("Microsoft.UI.Xaml.Markup.Compiler", " 1.0.0.0")]
        private bool _contentLoaded;

        /// <summary>
        /// InitializeComponent()
        /// </summary>
        [global::System.CodeDom.Compiler.GeneratedCodeAttribute("Microsoft.UI.Xaml.Markup.Compiler", " 1.0.0.0")]
        [global::System.Diagnostics.DebuggerNonUserCodeAttribute()]
        public void InitializeComponent()
        {
            if (_contentLoaded)
                return;

            _contentLoaded = true;

            global::System.Uri resourceLocator = new global::System.Uri("ms-appx:///Pages/ShellPage.xaml");
            global::Microsoft.UI.Xaml.Application.LoadComponent(this, resourceLocator, global::Microsoft.UI.Xaml.Controls.Primitives.ComponentResourceLocation.Application);
        }

        partial void UnloadObject(global::Microsoft.UI.Xaml.DependencyObject unloadableObject);

        [global::System.CodeDom.Compiler.GeneratedCodeAttribute("Microsoft.UI.Xaml.Markup.Compiler", " 1.0.0.0")]
        private interface IShellPage_Bindings
        {
            void Initialize();
            void Update();
            void StopTracking();
            void DisconnectUnloadedObject(int connectionId);
        }

        private interface IShellPage_BindingsScopeConnector
        {
            global::System.WeakReference Parent
            {
                get; set;
            }
            bool ContainsElement(int connectionId);
            void RegisterForElementConnection(int connectionId, global::Microsoft.UI.Xaml.Markup.IComponentConnector connector);
        }

        internal global::Microsoft.UI.Xaml.Controls.Grid AppTitleBar;
        internal global::Microsoft.UI.Xaml.Controls.TextBlock AppTitleBarText;
        internal global::Microsoft.UI.Xaml.Controls.NavigationView NavigationViewControl;
        internal global::Microsoft.UI.Xaml.Controls.Frame NavigationFrame;
#pragma warning restore 0649
#pragma warning restore 0169
    }
}

